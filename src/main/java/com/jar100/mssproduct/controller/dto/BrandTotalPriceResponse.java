package com.jar100.mssproduct.controller.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BrandTotalPriceResponse(
    String brand,
    List<CategoryPrice> categories,
    Integer total
) {
    @Builder
    public record CategoryPrice(
        String category,
        Integer price
    ) {
    }
}
