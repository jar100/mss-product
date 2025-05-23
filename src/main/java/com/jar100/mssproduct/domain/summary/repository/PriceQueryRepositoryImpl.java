package com.jar100.mssproduct.domain.summary.repository;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.brand.entity.QBrandEntity;
import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryPriceRange;
import com.jar100.mssproduct.domain.summary.entity.BrandTotalSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.QBrandCategoryMinPriceSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.QBrandTotalSummaryEntity;
import com.jar100.mssproduct.domain.summary.entity.QCategoryPriceSummaryEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.dsl.Expressions.list;

@Repository
@RequiredArgsConstructor
public class PriceQueryRepositoryImpl implements PriceQueryRepository {
    private final JPAQueryFactory queryFactory;
    private final QBrandEntity brand = QBrandEntity.brandEntity;
    private final QCategoryPriceSummaryEntity categoryPriceSummaryEntity = QCategoryPriceSummaryEntity.categoryPriceSummaryEntity;
    private final QBrandCategoryMinPriceSummaryEntity brandCategoryMinPriceSummaryEntity = QBrandCategoryMinPriceSummaryEntity.brandCategoryMinPriceSummaryEntity;
    private final QBrandTotalSummaryEntity brandTotalSummaryEntity = QBrandTotalSummaryEntity.brandTotalSummaryEntity;

    @Override
    public List<CategoryMinPrice> findMinPriceByCategory() {
        return queryFactory
            .select(Projections.constructor(
                CategoryMinPrice.class,
                categoryPriceSummaryEntity.category.stringValue(),
                brand.name,
                categoryPriceSummaryEntity.minPrice.castToNum(BigDecimal.class)
            ))
            .from(categoryPriceSummaryEntity)
            .join(brand).on(categoryPriceSummaryEntity.minBrandId.eq(brand.id))
            .orderBy(categoryPriceSummaryEntity.category.asc())
            .fetch();
    }

    @Override
    public BrandTotalPrice findLowestTotalByBrand() {
        // 1) BrandTotalSummaryEntity 에서 총액 최저 행 한 건 가져오기
        BrandTotalSummaryEntity summary = queryFactory
            .selectFrom(brandTotalSummaryEntity)
            .orderBy(brandTotalSummaryEntity.totalPrice.asc())
            .limit(1)
            .fetchOne();

        // 2) 그 브랜드의 이름 조회
        String brandName = queryFactory
            .select(brand.name)
            .from(brand)
            .where(brand.id.eq(summary.getMinBrandId()))
            .fetchOne();

        // 3) BrandCategoryMinPriceSummaryEntity 에서 해당 브랜드의 카테고리별 최소가 리스트 조회
        List<BrandTotalPrice.CategoryPrice> categories = queryFactory
            .select(Projections.constructor(
                BrandTotalPrice.CategoryPrice.class,
                brandCategoryMinPriceSummaryEntity.id.category.stringValue(),
                brandCategoryMinPriceSummaryEntity.minPrice
            ))
            .from(brandCategoryMinPriceSummaryEntity)
            .where(brandCategoryMinPriceSummaryEntity.id.brandId.eq(summary.getMinBrandId()))
            .orderBy(brandCategoryMinPriceSummaryEntity.id.category.asc())
            .fetch();

        // 4) DTO 조립 및 반환
        return new BrandTotalPrice(
            brandName,
            summary.getTotalPrice(),
            categories
        );
    }

    @Override
    public CategoryPriceRange findPriceRangeByCategory(String categoryName) {
        Category category = Category.valueOf(categoryName.toUpperCase());

        // 1) 최저가 리스트
        List<CategoryPriceRange.BrandPrice> minList = queryFactory
            .select(Projections.constructor(
                CategoryPriceRange.BrandPrice.class,
                brand.name,
                categoryPriceSummaryEntity.minPrice.castToNum(BigDecimal.class)
            ))
            .from(categoryPriceSummaryEntity)
            .join(brand).on(brand.id.eq(categoryPriceSummaryEntity.minBrandId))
            .where(categoryPriceSummaryEntity.category.eq(category))
            .fetch();

        // 2) 최고가 리스트
        List<CategoryPriceRange.BrandPrice> maxList = queryFactory
            .select(Projections.constructor(
                CategoryPriceRange.BrandPrice.class,
                brand.name,
                categoryPriceSummaryEntity.maxPrice.castToNum(BigDecimal.class)
            ))
            .from(categoryPriceSummaryEntity)
            .join(brand).on(brand.id.eq(categoryPriceSummaryEntity.maxBrandId))
            .where(categoryPriceSummaryEntity.category.eq(category))
            .fetch();

        // 3) 레코드 생성
        return CategoryPriceRange.builder()
            .category(category.name())
            .min(minList)
            .max(maxList)
            .build();
    }
}
