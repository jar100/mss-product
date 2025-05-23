package com.jar100.mssproduct.domain.summary.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record BrandTotalPrice(
    String brand,
    Integer total,
    List<CategoryPrice> categories
) {
    @Builder
    public record CategoryPrice(
        String category,
        Integer price
    ) {
    }
}
