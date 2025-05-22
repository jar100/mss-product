package com.jar100.mssproduct.domain.product.entity;

import com.jar100.mssproduct.common.entity.BaseEntity;
import com.jar100.mssproduct.domain.product.dto.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
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

    private Long brandId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private BigDecimal price;

    @Builder.Default
    private boolean deleted = false;

    public void change(String name, Long brandId, Category category, BigDecimal price) {
        this.name = name;
        this.brandId = brandId;
        this.category = category;
        this.price = price;
    }
}
