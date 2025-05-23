package com.jar100.mssproduct.domain.summary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandCategoryKey implements Serializable {
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "category", length = 20)
    private String category;
}
