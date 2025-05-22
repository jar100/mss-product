package com.jar100.mssproduct.domain.price.dto;

public record BrandTotalPrice(
    String brand,
    Integer total,
    CategoryPrice[] categories
) {
    public record CategoryPrice(
        String category,
        Integer price
    ) {
    }
}
