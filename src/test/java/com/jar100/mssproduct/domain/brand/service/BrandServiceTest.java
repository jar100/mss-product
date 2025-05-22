package com.jar100.mssproduct.domain.brand.service;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.common.exception.BrandNotFoundException;
import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.dto.BrandUpdate;
import com.jar100.mssproduct.domain.brand.entity.BrandEntity;
import com.jar100.mssproduct.domain.brand.repository.BrandRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DBRider
@DBUnit(schema = "PUBLIC")
@SpringBootTest
@ActiveProfiles("test")
class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @Test
    @DataSet(cleanBefore = true)
    @DisplayName("브랜드 생성 후 조회")
    void create_and_retrieve_brand() {
        // given
        BrandCreation creation = BrandCreation.builder()
            .name("TestBrand")
            .build();

        // when
        BrandInfo info = brandService.create(creation);

        // then
        Optional<BrandEntity> found = brandRepository.findById(info.id());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("TestBrand");
    }

    @Test
    @DataSet(value = "datasets/brand_update.yml", cleanBefore = true)
    @DisplayName("기존 브랜드 정보 수정")
    void update_existing_brand() {
        // given
        BrandUpdate update = BrandUpdate.builder()
            .id(1L)
            .name("NewName")
            .build();

        // when
        BrandInfo updated = brandService.update(update);

        // then
        assertThat(updated.id()).isEqualTo(update.id());
        assertThat(updated.name()).isEqualTo(update.name());
        assertThat(updated.createdAt()).isNotNull();
        assertThat(updated.updatedAt()).isNotNull();

        BrandEntity entity = brandRepository.findById(update.id()).get();
        assertThat(entity.getName()).isEqualTo("NewName");
        assertThat(entity.getCreatedAt()).isNotNull();
        assertThat(entity.getUpdatedAt()).isNotNull();
        assertThat(entity.getUpdatedAt()).isAfter(entity.getCreatedAt());

    }

    @Test
    @DataSet(cleanBefore = true)
    @DisplayName("존재하지 않는 브랜드 수정 시 예외 발생")
    void update_nonexistent_brand_should_throw() {
        // given
        BrandUpdate update = new BrandUpdate(999L, "X");

        // when & then
        assertThrows(BrandNotFoundException.class,
            () -> brandService.update(update));
    }

    @Test
    @DataSet(cleanBefore = true)
    @DisplayName("브랜드 소프트 삭제")
    void delete_brand_soft() {
        // given
        BrandEntity entity = brandRepository.save(BrandEntity.builder().name("TestBrand").build());

        // when
        brandService.delete(entity.getId());

        // then
        List<BrandEntity> all = brandRepository.findAll();
        assertThat(all).isEmpty();
    }

    @Test
    @DataSet(value = "datasets/brand_list.yml", cleanBefore = true)
    @DisplayName("listAll은 삭제되지 않은 모든 브랜드 반환")
    void listAll_returns_all_active_brands() {
        // given
        // soft delete B
        brandService.delete(2L);

        // when
        List<BrandInfo> infos = brandService.listAll();

        // then
        assertThat(infos).extracting(BrandInfo::name).containsExactly("A", "C");
    }
}