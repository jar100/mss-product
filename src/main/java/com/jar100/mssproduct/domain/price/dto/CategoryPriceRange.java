package com.jar100.mssproduct.domain.price.dto;

import com.jar100.mssproduct.controller.dto.CategoryPriceRangeResponse;
import lombok.Builder;

import java.util.List;

public record CategoryPriceRange(
    String category,
    List<CategoryPriceRangeResponse.BrandPrice> min,
    List<CategoryPriceRangeResponse.BrandPrice> max
) {
    @Builder
    public record BrandPrice(
        String brand,
        Integer price
    ) {
    }
}
