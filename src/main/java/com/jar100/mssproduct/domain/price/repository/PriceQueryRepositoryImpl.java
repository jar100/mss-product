package com.jar100.mssproduct.domain.price.repository;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.brand.entity.QBrandEntity;
import com.jar100.mssproduct.domain.price.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.price.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.price.dto.CategoryPriceRange;
import com.jar100.mssproduct.domain.product.entity.QProductEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PriceQueryRepositoryImpl implements PriceQueryRepository {
    private final JPAQueryFactory queryFactory;
    private final QProductEntity product = QProductEntity.productEntity;
    private final QBrandEntity brand = QBrandEntity.brandEntity;

    /**
     * 카테고리별 최저가
     * 카테고리는 변경이 많지않은 데이터라고 판단하여 카테고리별 최저가를 가져오는 쿼리 * N 로 작성
     * @return
     */
    @Override
    public List<CategoryMinPrice> findMinPriceByCategory() {
        List<CategoryMinPrice> results = new ArrayList<>();
        for (Category category : Category.values()) {
            CategoryMinPrice resp = queryFactory
                .select(Projections.constructor(
                    CategoryMinPrice.class,
                    product.category.stringValue(),
                    brand.name,
                    product.price
                ))
                .from(product)
                .join(brand).on(product.brandId.eq(brand.id))
                .where(product.category.eq(category))
                .orderBy(product.price.asc())
                .limit(1)
                .fetchOne();
            if (resp != null) {
                results.add(resp);
            }
        }
        return results;
    }

    @Override
    public BrandTotalPrice findLowestTotalByBrand() {
        return null;
    }

    @Override
    public CategoryPriceRange findPriceRangeByCategory(String categoryName) {
        return null;
    }
}
