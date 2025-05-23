package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryPriceRange;

import java.util.List;

public interface PriceService {
    // 1) 카테고리별 최저가
    List<CategoryMinPrice> findMinPriceByCategory();

    // 2) 브랜드별 최소 총액
    BrandTotalPrice findLowestTotalByBrand();

    // 3) 카테고리별 가격 범위
    CategoryPriceRange findPriceRangeByCategory(String categoryName);
}
