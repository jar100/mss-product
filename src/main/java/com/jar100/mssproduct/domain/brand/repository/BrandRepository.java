package com.jar100.mssproduct.domain.brand.repository;

import com.jar100.mssproduct.domain.brand.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
