package com.jar100.mssproduct.domain.brand.dto;

import lombok.Builder;

@Builder
public record BrandUpdate(
    Long id,
    String name
) {
}
