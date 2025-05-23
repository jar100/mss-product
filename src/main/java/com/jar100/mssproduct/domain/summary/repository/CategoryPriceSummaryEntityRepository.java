package com.jar100.mssproduct.domain.summary.repository;

import com.jar100.mssproduct.domain.summary.entity.CategoryPriceSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryPriceSummaryEntityRepository extends JpaRepository<CategoryPriceSummaryEntity, Long>{
    List<CategoryPriceSummaryEntity> findAll();
}
