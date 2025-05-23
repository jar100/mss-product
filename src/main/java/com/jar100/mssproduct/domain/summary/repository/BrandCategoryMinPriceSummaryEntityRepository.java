package com.jar100.mssproduct.domain.summary.repository;

import com.jar100.mssproduct.domain.summary.entity.BrandCategoryKey;
import com.jar100.mssproduct.domain.summary.entity.BrandCategoryMinPriceSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandCategoryMinPriceSummaryEntityRepository extends JpaRepository<BrandCategoryMinPriceSummaryEntity, BrandCategoryKey> {
    // Custom query methods can be defined here if needed

}
