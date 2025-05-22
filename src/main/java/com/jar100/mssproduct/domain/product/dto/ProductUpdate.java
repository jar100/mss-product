package com.jar100.mssproduct.domain.product.dto;

public record ProductUpdate(
    Long id,
    String name,
    Long brandId,
    Category category,
    Integer price
) {
}
