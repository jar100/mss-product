package com.jar100.mssproduct.domain.summary.dto;

import com.jar100.mssproduct.controller.dto.CategoryPriceRangeResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CategoryPriceRange(
    String category,
    List<BrandPrice> min,
    List<BrandPrice> max
) {
    @Builder
    public record BrandPrice(
        String brand,
        BigDecimal price
    ) {
    }
}
