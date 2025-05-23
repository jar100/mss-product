package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.brand.entity.QBrandEntity;
import com.jar100.mssproduct.domain.product.entity.QProductEntity;
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
    private final CategoryPriceSummaryEntityRepository cpsRepo;
    private final BrandCategoryMinPriceSummaryEntityRepository bcpsRepo;
    private final BrandTotalSummaryEntityRepository     btsRepo;
    private final QProductEntity product  = QProductEntity.productEntity;
    private final BrandTotalSummaryEntityRepository brandTotalSummaryEntityRepository;
    QBrandCategoryMinPriceSummaryEntity bcmpsEntity = QBrandCategoryMinPriceSummaryEntity.brandCategoryMinPriceSummaryEntity;


    //운영 가정: 브랜드 10,000개 × 상품 50,000건/브랜드 = 약 500백만 건의 상품 데이터가 있다고 가정
    // 데이터 반영이 안됬을 경우에 대비해, 1일 1회 배치로 반영
    //todo  풀 스켄은 부담이 크므로, 오늘 날짜 기준으로 1일 전 데이터만 반영
    @Scheduled(cron = "0 0 1 * * *")
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
                CategoryPriceSummaryEntity summary = CategoryPriceSummaryEntity.builder()
                    .category(cat)                      // enum 그대로
                    .minBrandId(min.get(product.brandId))
                    .minProductId(min.get(product.id))
                    .minPrice(min.get(product.price.intValue()))
                    .maxBrandId(max.get(product.brandId))
                    .maxProductId(max.get(product.id))
                    .maxPrice(max.get(product.price.intValue()))
                    .build();
                catSummaries.add(summary);
            }
        }
        cpsRepo.saveAll(catSummaries);

        // 2) 브랜드 & 카테고리별 최소가
        List<BrandCategoryMinPriceSummaryEntity> brandCatSummaries = qf
            .select(Projections.constructor(
                BrandCategoryMinPriceSummaryEntity.class,
                product.brandId,
                product.category.stringValue(),
                product.price.min()
            ))
            .from(product)
            .groupBy(product.brandId, product.category)
            .fetch();
        bcpsRepo.saveAll(brandCatSummaries);

        // 3) 브랜드별 총액
        BrandTotalSummaryEntity brandTotalSummaryEntity = qf.select(
                Projections.constructor(
                    BrandTotalSummaryEntity.class,
                    bcmpsEntity.id.brandId,
                    bcmpsEntity.minPrice.sum()
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
