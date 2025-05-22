package com.jar100.mssproduct.domain.product.entity;

import com.jar100.mssproduct.common.entity.BaseEntity;
import com.jar100.mssproduct.domain.product.dto.Category;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Entity
@Table(
    name = "product",
    indexes = {
        @Index(name = "idx_product_category_price", columnList = "category,price"),
        @Index(name = "idx_product_brand_price",    columnList = "brand_id,price"),
        @Index(name = "idx_product_brand_category", columnList = "brand_id,category")
    }
)
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private Category category;

    @Column(nullable = false)
    private BigDecimal price;

    @Builder.Default
    private boolean deleted = false;

    public void change(ProductUpdate update) {
        // name
        if (update.name() != null) {
            this.name = update.name();
        }
        // brandId
        if (update.brandId() != null) {
            this.brandId = update.brandId();
        }
        // category
        if (update.category() != null) {
            this.category = update.category();
        }
        // price
        if (update.price() != null && update.price() > 0) {
            this.price = BigDecimal.valueOf(update.price());
        }
    }
}
