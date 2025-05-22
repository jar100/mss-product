package com.jar100.mssproduct.domain.brand.dto;

import lombok.Builder;

@Builder
public record BrandInfo(
    Long id,
    String name
) {
}
