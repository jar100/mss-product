package com.jar100.mssproduct.domain.price.repository;

import com.jar100.mssproduct.domain.price.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.price.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.price.dto.CategoryPriceRange;

import java.util.List;

public interface PriceQueryRepository {
    // 1) 카테고리별 최저가
    List<CategoryMinPrice> findMinPriceByCategory();

    // 2) 브랜드별 최소 총액
    BrandTotalPrice findLowestTotalByBrand();

    // 3) 카테고리별 가격 범위
    CategoryPriceRange findPriceRangeByCategory(String categoryName);
}
