package com.jar100.mssproduct.controller.dto;

import com.jar100.mssproduct.domain.product.dto.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateRequest(
    @NotBlank String name,
    @NotNull Long brandId,
    @NotNull Category category,
    @NotNull @Min(0) Integer price
) {
}