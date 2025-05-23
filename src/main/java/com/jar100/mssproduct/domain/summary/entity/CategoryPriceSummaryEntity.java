package com.jar100.mssproduct.domain.summary.entity;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_price_summary")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryPriceSummaryEntity extends BaseEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "varchar(100)")
    private Category category;

    @Column(name = "min_brand_id", nullable = false)
    private Long minBrandId;

    @Column(name = "min_product_id", nullable = false)
    private Long minProductId;

    @Column(name = "min_price", nullable = false)
    private Integer minPrice;

    @Column(name = "max_brand_id", nullable = false)
    private Long maxBrandId;

    @Column(name = "max_product_id", nullable = false)
    private Long maxProductId;

    @Column(name = "max_price", nullable = false)
    private Integer maxPrice;

    @Version
    @Column(name = "version")
    private Long version;

    public void updateMinMaxPrice(Long minBrandId, Long minProductId, Integer minPrice, Long maxBrandId, Long maxProductId, Integer maxPrice) {
        this.minBrandId = minBrandId;
        this.minProductId = minProductId;
        this.minPrice = minPrice;
        this.maxBrandId = maxBrandId;
        this.maxProductId = maxProductId;
        this.maxPrice = maxPrice;
    }
}
