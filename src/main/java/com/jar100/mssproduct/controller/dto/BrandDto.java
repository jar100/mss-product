package com.jar100.mssproduct.controller.dto;

import java.time.LocalDateTime;

public record BrandDto(
    Long id,
    String name,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
