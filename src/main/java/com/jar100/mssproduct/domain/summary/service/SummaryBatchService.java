package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.product.entity.QProductEntity;
import com.jar100.mssproduct.domain.summary.entity.BrandCategoryKey;
import com.jar100.mssproduct.domain.summary.entity.BrandCategoryMinPriceSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.BrandTotalSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.CategoryPriceSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.QBrandCategoryMinPriceSummaryEntity;
import com.jar100.mssproduct.domain.summary.repository.BrandCategoryMinPriceSummaryEntityRepository;
import com.jar100.mssproduct.domain.summary.repository.BrandTotalSummaryEntityRepository;
import com.jar100.mssproduct.domain.summary.repository.CategoryPriceSummaryEntityRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryBatchService {
    private final JPAQueryFactory qf;
    private final CategoryPriceSummaryEntityRepository categoryPriceSummaryEntityRepository;
    private final BrandCategoryMinPriceSummaryEntityRepository brandCategoryMinPriceSummaryEntityRepository;
    private final BrandTotalSummaryEntityRepository brandTotalSummaryEntityRepository;
    private final QProductEntity product  = QProductEntity.productEntity;
    private final QProductEntity product2 = new QProductEntity("product2");
    QBrandCategoryMinPriceSummaryEntity bcmpsEntity = QBrandCategoryMinPriceSummaryEntity.brandCategoryMinPriceSummaryEntity;


    //운영 가정: 브랜드 10,000개 × 상품 50,000건/브랜드 = 약 500백만 건의 상품 데이터가 있다고 가정
    // 데이터 반영이 안됬을 경우에 대비해, 1일 1회 배치로 반영
    //todo  풀 스켄은 부담이 크므로, 오늘 날짜 기준으로 1일 전 데이터만 반영
    //@Scheduled(cron = "0 0 1 * * *")
    @Transactional
    public void refreshSummaries() {
        // 1) 카테고리별 최소·최대가
        List<CategoryPriceSummaryEntity> catSummaries = new ArrayList<>();
        for (Category cat : Category.values()) {
            // 최소가 한 건
            Tuple min = qf
                .select(
                    product.category,
                    product.brandId,
                    product.id,
                    product.price
                )
                .from(product)
                .where(product.category.eq(cat))
                .orderBy(product.price.asc())
                .limit(1)
                .fetchOne();

            // 최대가 한 건
            Tuple max = qf
                .select(
                    product.brandId,
                    product.id,
                    product.price
                )
                .from(product)
                .where(product.category.eq(cat))
                .orderBy(product.price.desc())
                .limit(1)
                .fetchOne();

            if (min != null && max != null) {
                int minPrice = min.get(product.price)      // BigDecimal
                    .intValue();            // → int
                int maxPrice = max.get(product.price)
                    .intValue();
                CategoryPriceSummaryEntity summary = CategoryPriceSummaryEntity.builder()
                    .category(cat)                      // enum 그대로
                    .minBrandId(min.get(product.brandId))
                    .minProductId(min.get(product.id))
                    .minPrice(minPrice)
                    .maxBrandId(max.get(product.brandId))
                    .maxProductId(max.get(product.id))
                    .maxPrice(maxPrice)
                    .build();
                catSummaries.add(summary);
            }
        }
        categoryPriceSummaryEntityRepository.saveAll(catSummaries);

        // 2) 브랜드 & 카테고리별 최소가
        List<BrandCategoryMinPriceSummaryEntity> brandCatSummaries =
            qf.select(Projections.constructor(
                    BrandCategoryMinPriceSummaryEntity.class,
                    // 1) 복합키: brandId + category
                    Projections.constructor(
                        BrandCategoryKey.class,
                        product.brandId,
                        product.category.stringValue()
                    ),
                    // 2) subquery: 이 브랜드·카테고리에서 가장 낮은 가격을 가진 product.id
                    JPAExpressions.select(product2.id)
                        .from(product2)
                        .where(product2.brandId.eq(product.brandId)
                            .and(product2.category.eq(product.category)))
                        .orderBy(product2.price.asc())
                        .limit(1),
                    // 3) min price 값
                    product.price.min().castToNum(Integer.class))
                )
                .from(product)
                // product2 는 QProductEntity("product2") 로 미리 선언
                .groupBy(product.brandId, product.category)
                .fetch();

        brandCategoryMinPriceSummaryEntityRepository.saveAll(brandCatSummaries);

        // 3) 브랜드별 총액
        BrandTotalSummaryEntity brandTotalSummaryEntity = qf.select(
                Projections.constructor(
                    BrandTotalSummaryEntity.class,
                    Expressions.constant(1L),                        // id 고정
                    bcmpsEntity.id.brandId,
                    bcmpsEntity.minPrice.sum().castToNum(Integer.class).as("totalPrice")
                ))
            .from(bcmpsEntity)
            .groupBy(bcmpsEntity.id.brandId).orderBy(
                bcmpsEntity.minPrice.sum().asc()
            ).limit(1).fetchOne();
        if (brandTotalSummaryEntity != null) {
            brandTotalSummaryEntityRepository.save(brandTotalSummaryEntity);
        }
    }
}
