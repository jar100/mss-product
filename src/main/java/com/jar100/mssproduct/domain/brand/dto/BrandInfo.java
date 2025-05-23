package com.jar100.mssproduct.domain.brand.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BrandInfo(
    Long id,
    String name,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
