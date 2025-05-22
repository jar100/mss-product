package com.jar100.mssproduct.domain.product.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@DBUnit(schema = "PUBLIC")
@SpringBootTest
@ActiveProfiles("test")
class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;

    @Test
    @DataSet(value = "datasets/product.yml", cleanBefore = true)
    void findById_shouldReturnActiveEntity() {
        Optional<ProductEntity> p1 = repository.findById(1L);
        Optional<ProductEntity> p2 = repository.findById(3L);
        assertThat(p1).isPresent();
        assertThat(p1.get().getName()).isEqualTo("Product A");
        assertThat(p1.get().getCategory()).isEqualTo(Category.TOP);
        assertThat(p2).isEmpty();
    }

    @Test
    @DataSet(value = "datasets/product.yml", cleanBefore = true)
    void findAll_shouldExcludeDeleted() {
        var all = repository.findAll();
        assertThat(all).hasSize(2)
            .extracting(ProductEntity::getName)
            .containsExactly("Product A", "Product B");
    }
}