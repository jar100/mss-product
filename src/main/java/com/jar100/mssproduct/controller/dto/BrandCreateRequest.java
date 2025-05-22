package com.jar100.mssproduct.controller.dto;

import jakarta.validation.constraints.NotNull;

public record BrandCreateRequest(
    @NotNull String name
) {
}
