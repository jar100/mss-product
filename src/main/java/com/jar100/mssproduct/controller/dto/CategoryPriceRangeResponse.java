package com.jar100.mssproduct.controller.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CategoryPriceRangeResponse(
    String category,
    List<BrandPrice> min,
    List<BrandPrice> max
) {
    @Builder
    public record BrandPrice(
        String brand,
        Integer price
    ) {
    }
}
