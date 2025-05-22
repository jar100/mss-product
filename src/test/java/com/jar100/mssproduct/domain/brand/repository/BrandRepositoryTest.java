package com.jar100.mssproduct.domain.brand.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.domain.brand.entity.BrandEntity;
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
class BrandRepositoryTest {
    @Autowired
    private BrandRepository brandRepository;

    @Test
    @DataSet(value = "datasets/brand.yml", cleanBefore = true)
    void findById_shouldReturnActiveEntity() {
        // given when
        Optional<BrandEntity> aBrand = brandRepository.findById(1L);
        Optional<BrandEntity> cBrand = brandRepository.findById(3L);

        // then
        assertThat(aBrand).isPresent();
        assertThat(aBrand.get().getName()).isEqualTo("A");
        assertThat(cBrand).isEmpty();
    }

    @Test
    @DataSet(value = "datasets/brand.yml", cleanBefore = true)
    void findAll_shouldExcludeDeleted() {
        // when
        var all = brandRepository.findAll();

        // then
        assertThat(all).hasSize(2)
            .extracting(BrandEntity::getName)
            .containsExactlyInAnyOrder("A", "B");
    }
}