package com.jar100.mssproduct.domain.price.dto;

import java.math.BigDecimal;

public record CategoryMinPrice(
    String category,
    String brand,
    BigDecimal price
) {
}
