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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        extractedCategoryPriceSummaryEntity();

        extractedBrandCategoryMinPriceSummaryEntity();

        extractedBrandTotalSummaryEntity();
    }

    private void extractedBrandTotalSummaryEntity() {
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
        // 4) 기존 DB에 저장된 것들을 키(brandId) 로 한 번에 조회
        Optional<BrandTotalSummaryEntity> old = brandTotalSummaryEntityRepository.findById(1L);
        if (old.isPresent()) {
            // 5) 기존 엔티티 가져와서 값만 덮어쓰기
            BrandTotalSummaryEntity oldEntity = old.get();
            oldEntity.updateTotalPrice(brandTotalSummaryEntity.getTotalPrice());
            brandTotalSummaryEntity = oldEntity;
        }
        // 6) saveAll 로 한 번에 persist/merge 처리
        brandTotalSummaryEntityRepository.save(brandTotalSummaryEntity);
    }

    private void extractedBrandCategoryMinPriceSummaryEntity() {
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

        // 2) 기존 DB에 저장된 것들을 키(brandId+category) 로 한 번에 조회
        List<BrandCategoryKey> keys = brandCatSummaries.stream()
            .map(BrandCategoryMinPriceSummaryEntity::getId)
            .toList();
        Map<BrandCategoryKey, BrandCategoryMinPriceSummaryEntity> existingMap =
            brandCategoryMinPriceSummaryEntityRepository.findAllById(keys).stream()
                .collect(Collectors.toUnmodifiableMap(
                    BrandCategoryMinPriceSummaryEntity::getId,
                    Function.identity()
                ));

        // 3) “있으면 update, 없으면 insert” 분리
        List<BrandCategoryMinPriceSummaryEntity> toSave = new ArrayList<>();
        for (var newSum : brandCatSummaries) {
            var key = newSum.getId();
            if (existingMap.containsKey(key)) {
                // 기존 엔티티 가져와서 값만 덮어쓰기
                var old = existingMap.get(key);
                old.updateMinPrice(newSum.getMinProductId(), newSum.getMinPrice());
                toSave.add(old);
            } else {
                toSave.add(newSum);
            }
        }
        // 4) saveAll 로 한 번에 persist/merge 처리
        brandCategoryMinPriceSummaryEntityRepository.saveAll(toSave);
    }

    private void extractedCategoryPriceSummaryEntity() {
        // 1) 카테고리별 최소/최대가 계산
        List<CategoryPriceSummaryEntity> computed = new ArrayList<>();
        for (Category cat : Category.values()) {
            Tuple min = qf.select(
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

            Tuple max = qf.select(
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
                CategoryPriceSummaryEntity e = CategoryPriceSummaryEntity.builder()
                    .category(cat)
                    .minBrandId( min.get(product.brandId) )
                    .minProductId( min.get(product.id) )
                    .minPrice( min.get(product.price).intValue() )
                    .maxBrandId( max.get(product.brandId) )
                    .maxProductId( max.get(product.id) )
                    .maxPrice( max.get(product.price).intValue() )
                    .build();
                computed.add(e);
            }
        }

        if (computed.isEmpty()) {
            return;
        }

        // 2) 기존 요약을 일괄 조회
        List<Category> keys = computed.stream()
            .map(CategoryPriceSummaryEntity::getCategory)
            .toList();
        Map<Category, CategoryPriceSummaryEntity> existing = categoryPriceSummaryEntityRepository.findAllById(keys).stream()
            .collect(Collectors.toMap(
                CategoryPriceSummaryEntity::getCategory,
                Function.identity()
            ));

        // 3) upsert 분기: 있으면 update, 없으면 insert
        List<CategoryPriceSummaryEntity> toSave = new ArrayList<>();
        for (CategoryPriceSummaryEntity newSum : computed) {
            Category cat = newSum.getCategory();
            if (existing.containsKey(cat)) {
                CategoryPriceSummaryEntity old = existing.get(cat);
                old.updateMinMaxPrice(
                    newSum.getMinBrandId(),
                    newSum.getMinProductId(),
                    newSum.getMinPrice(),
                    newSum.getMaxBrandId(),
                    newSum.getMaxProductId(),
                    newSum.getMaxPrice()
                );
                toSave.add(old);
            } else {
                toSave.add(newSum);
            }
        }
        // 4) saveAll()으로 insert or merge 처리
        categoryPriceSummaryEntityRepository.saveAll(toSave);
    }
}
