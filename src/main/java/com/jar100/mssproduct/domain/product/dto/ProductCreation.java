package com.jar100.mssproduct.domain.product.dto;

public record ProductCreation(
    String name,
    Long brandId,
    Category category,
    Integer price
) {
}

