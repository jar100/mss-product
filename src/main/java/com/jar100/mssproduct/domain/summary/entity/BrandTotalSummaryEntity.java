package com.jar100.mssproduct.domain.summary.entity;

import com.jar100.mssproduct.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand_total_summary")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandTotalSummaryEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    private Long id;

    /** 총액 최저 브랜드 */
    @Column(name = "min_brand_id", nullable = false)
    private Long minBrandId;

    /** 총액 */
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;


    @Version
    @Column(name = "version")
    private Long version;
}
