package com.jar100.mssproduct.controller.dto;

import lombok.Builder;

@Builder
public record CategoryMinPrice(
    String category,
    String brand,
    String price
) {
}
