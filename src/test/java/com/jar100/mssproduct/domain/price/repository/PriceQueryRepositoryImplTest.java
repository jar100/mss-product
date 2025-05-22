package com.jar100.mssproduct.domain.price.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.jar100.mssproduct.common.dto.Category;
import com.jar100.mssproduct.domain.price.dto.CategoryMinPrice;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DBRider
@DBUnit(schema = "PUBLIC")
@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PriceQueryRepositoryImplTest {
    @Autowired
    private PriceQueryRepository priceQueryRepository;

    @Test
    @DataSet(value = {"datasets/find_min_price_by_category.yml"}, cleanBefore = true)
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
        assertThat(outer.brand()).isEqualTo("D");
        assertThat(outer.price().intValue()).isEqualTo(5100);

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

}