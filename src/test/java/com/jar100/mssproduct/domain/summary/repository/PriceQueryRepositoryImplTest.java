package com.jar100.mssproduct.domain.summary.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@DBUnit(schema = "PUBLIC")
@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PriceQueryRepositoryImplTest {
    @Autowired
    private PriceQueryRepository priceQueryRepository;

    @Test
    @DataSet(value = {"default_data_set.yml", "datasets/price_query.yml"}, cleanBefore = true)
    void findMinPriceByCategory_shouldReturnLowestPerCategory() {
        // when
        List<CategoryMinPrice> results = priceQueryRepository.findMinPriceByCategory();

        // then
        assertThat(results).hasSize(Category.values().length);

        CategoryMinPrice top = results.stream()
            .filter(r -> r.category().equals(Category.TOP.name()))
            .findFirst().orElseThrow();
        assertThat(top.brand()).isEqualTo("C");
        assertThat(top.price().intValue()).isEqualTo(10000);

        CategoryMinPrice outer = results.stream()
            .filter(r -> r.category().equals(Category.OUTER.name()))
            .findFirst().orElseThrow();
        assertThat(outer.brand()).isEqualTo("E");
        assertThat(outer.price().intValue()).isEqualTo(5000);

        CategoryMinPrice pants = results.stream()
            .filter(r -> r.category().equals(Category.PANTS.name()))
            .findFirst().orElseThrow();
        assertThat(pants.brand()).isEqualTo("D");
        assertThat(pants.price().intValue()).isEqualTo(3000);

        CategoryMinPrice accessory = results.stream()
            .filter(r -> r.category().equals(Category.ACCESSORY.name()))
            .findFirst().orElseThrow();
        assertThat(accessory.brand()).isEqualTo("C");
        assertThat(accessory.price().intValue()).isEqualTo(2100);
    }

    /**
     * 2) 브랜드별 최소 총액 조회
     */
    @Test
    @DataSet(value = {"default_data_set.yml", "price_query.yml"}, cleanBefore = true)
    void findLowestTotalByBrand_shouldReturnBrandWithMinimumTotal() {
        BrandTotalPrice resp = priceQueryRepository.findLowestTotalByBrand();
        // 브랜드 D가 총액 최소(36100)
        assertThat(resp.brand()).isEqualTo("D");
        assertThat(resp.total()).isEqualTo(36100);
        // 카테고리별 가격 개수
        assertThat(resp.categories()).hasSize(Category.values().length);
        // 특정 카테고리 검증 (상의)
        List<BrandTotalPrice.CategoryPrice> cats = resp.categories();
        BrandTotalPrice.CategoryPrice top = cats.stream()
            .filter(c -> c.category().equals(Category.TOP.name()))
            .findFirst().orElseThrow();
        assertThat(top.price()).isEqualTo(10100);
    }

    @Test
    @DataSet(value = {"default_data_set.yml", "price_query.yml"}, cleanBefore = true)
    void findPriceRangeByCategory_shouldReturnPriceRange() {
        // when
        String categoryName = Category.TOP.name();
        var resp = priceQueryRepository.findPriceRangeByCategory(categoryName);

        // then
        assertThat(resp).isNotNull();
        assertThat(resp.category()).isEqualTo(categoryName);
        assertThat(resp.min().get(0).price().intValue()).isEqualTo(10000);
        assertThat(resp.max().get(0).price().intValue()).isEqualTo(11200);
    }

}