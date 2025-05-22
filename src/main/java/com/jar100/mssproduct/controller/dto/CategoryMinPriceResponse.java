package com.jar100.mssproduct.controller.dto;

import lombok.Builder;

@Builder
public record CategoryMinPriceResponse(
    String category,
    String brand,
    String price
) {
}
