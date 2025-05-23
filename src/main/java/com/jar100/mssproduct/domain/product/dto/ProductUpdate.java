package com.jar100.mssproduct.domain.product.dto;

import com.jar100.mssproduct.common.dto.Category;
import lombok.Builder;

@Builder
public record ProductUpdate(
    Long id,
    String name,
    Long brandId,
    Category category,
    Integer price
) {
}
