package com.jar100.mssproduct.domain.summary.entity;

import com.jar100.mssproduct.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_category_min_price_summary")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandCategoryMinPriceSummaryEntity extends BaseEntity {
    @EmbeddedId
    private BrandCategoryKey id;

    @Version
    @Column(name = "version")
    private Long version;

    /** 최저가 상품 ID */
    @Column(name = "min_product_id", nullable = false)
    private Long minProductId;

    /** 최저가 */
    @Column(name = "min_price", nullable = false)
    private Integer minPrice;
}
