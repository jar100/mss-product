package com.jar100.mssproduct.domain.summary.service;

import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryPriceRange;
import com.jar100.mssproduct.domain.summary.repository.PriceQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    private final PriceQueryRepository priceQueryRepository;

    @Override
    public List<CategoryMinPrice> findMinPriceByCategory() {
        return priceQueryRepository.findMinPriceByCategory();
    }

    @Override
    public BrandTotalPrice findLowestTotalByBrand() {
        return priceQueryRepository.findLowestTotalByBrand();
    }

    @Override
    public CategoryPriceRange findPriceRangeByCategory(String categoryName) {
        return priceQueryRepository.findPriceRangeByCategory(categoryName);
    }
}
