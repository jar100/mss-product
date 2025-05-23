package com.jar100.mssproduct.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductChangedEvent {
    private Long productId;
    private Long brandId;
    private Category category;
    private BigDecimal price;
    private Type type;

    public enum Type { CREATE, UPDATE, DELETE }
}
