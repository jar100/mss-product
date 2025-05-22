package com.jar100.mssproduct.domain.product.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProductInfo(
    Long id,
    String name,
    Long brandId,
    Category category,
    Integer price,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
