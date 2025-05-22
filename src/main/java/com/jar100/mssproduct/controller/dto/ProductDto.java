package com.jar100.mssproduct.controller.dto;

import com.jar100.mssproduct.domain.product.dto.Category;

import java.math.BigDecimal;

public record ProductDto(
    Long id,
    String name,
    Long brandId,
    String brandName,
    Category category,
    BigDecimal price
) {
}
