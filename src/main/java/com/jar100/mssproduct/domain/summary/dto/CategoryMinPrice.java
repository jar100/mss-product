package com.jar100.mssproduct.domain.summary.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CategoryMinPrice(
    String category,
    String brand,
    BigDecimal price
) {
}
