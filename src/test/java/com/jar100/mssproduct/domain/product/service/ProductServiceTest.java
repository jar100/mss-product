package com.jar100.mssproduct.domain.product.service;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.common.exception.ProductNotFoundException;
import com.jar100.mssproduct.domain.brand.repository.BrandRepository;
import com.jar100.mssproduct.domain.product.dto.Category;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import com.jar100.mssproduct.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DBRider
@DBUnit(schema = "PUBLIC")
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository productRepository;


    @Test
    @DataSet(value = "datasets/brand.yml", cleanBefore = true)
    void create_shouldPersistProduct() {
        // given
        ProductCreation creation = ProductCreation.builder()
            .name("PNew")
            .brandId(1L)
            .category(Category.BAG)
            .price(1200)
            .build();

        // when
        ProductInfo info = service.create(creation);

        // then
        Optional<ProductEntity> found = productRepository.findById(info.id());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("PNew");
        assertThat(found.get().getCategory()).isEqualTo(Category.BAG);
    }

    @Test
    @DataSet(value = "product_update.yml", cleanBefore = true)
    void update_shouldModifyExistingProduct() {
        // given
        ProductUpdate update = ProductUpdate.builder()
            .id(10L)
            .name("UpdName")
            .category(Category.BAG)
            .price(2300)
            .build();

        // when
        ProductInfo info = service.update(update);

        // then
        assertThat(info.id()).isEqualTo(10L);
        assertThat(info.name()).isEqualTo("UpdName");
        assertThat(info.category()).isEqualTo(Category.BAG);
        // repository state
        ProductEntity entity = productRepository.findById(10L).get();
        assertThat(entity.getPrice().intValue()).isEqualTo(BigDecimal.valueOf(2300).intValue());
    }

    @Test
    @DataSet(value = {"datasets/product_update.yml"}, cleanBefore = true)
    void update_whenNotExists_shouldThrow() {
        ProductUpdate update = new ProductUpdate(999L, "X", 1L, Category.HAT, 200);
        assertThrows(ProductNotFoundException.class, () -> service.update(update));
    }
}