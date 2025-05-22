package com.jar100.mssproduct.domain.product.dto;

import lombok.Builder;

@Builder
public record ProductCreation(
    String name,
    Long brandId,
    Category category,
    Integer price
) {
}

