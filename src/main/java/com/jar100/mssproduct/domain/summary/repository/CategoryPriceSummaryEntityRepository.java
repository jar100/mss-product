package com.jar100.mssproduct.domain.summary.repository;

import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.summary.entity.CategoryPriceSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryPriceSummaryEntityRepository extends JpaRepository<CategoryPriceSummaryEntity, Category>{
    List<CategoryPriceSummaryEntity> findAll();

    Optional<CategoryPriceSummaryEntity> findByCategory(Category category);

}
