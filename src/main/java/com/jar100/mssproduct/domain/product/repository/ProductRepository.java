package com.jar100.mssproduct.domain.product.repository;

import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
