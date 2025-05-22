package com.jar100.mssproduct.domain.brand.entity;

import jakarta.persistence.Entity;
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

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brand")
@SQLDelete(sql = "UPDATE brand SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Soft delete flag
    @Builder.Default
    private boolean deleted = false;

    public void changeName(String name) {
        this.name = name;
    }
}
