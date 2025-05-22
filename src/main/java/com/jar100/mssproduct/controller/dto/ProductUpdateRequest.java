package com.jar100.mssproduct.controller.dto;

import com.jar100.mssproduct.domain.product.dto.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateRequest(
    @NotNull Long id,
    String name,
    Long brandId,
    Category category,
    @Min(1) Integer price
) {
}