package com.jar100.mssproduct.controller;

import com.jar100.mssproduct.common.dto.CommonResponse;
import com.jar100.mssproduct.controller.dto.BrandTotalPriceResponse;
import com.jar100.mssproduct.controller.dto.CategoryMinPriceResponse;
import com.jar100.mssproduct.controller.dto.CategoryPriceRangeResponse;
import com.jar100.mssproduct.controller.mapper.PriceControllerMapper;
import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryPriceRange;
import com.jar100.mssproduct.domain.summary.service.PriceService;
import com.jar100.mssproduct.domain.summary.service.SummaryBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {
    private final PriceService priceService;
    private final PriceControllerMapper priceControllerMapper;

    private final SummaryBatchService summaryBatchService;

    @GetMapping("/categories/lowest")
    public CommonResponse<List<CategoryMinPriceResponse>> findLowesByCategories() {
        List<CategoryMinPrice> categoryMinPrices = priceService.findMinPriceByCategory();
        return CommonResponse.success(priceControllerMapper.toResponse(categoryMinPrices));
    }

    @GetMapping("/brands/lowest-total")
    public CommonResponse<BrandTotalPriceResponse> findLowestByBrands() {
        BrandTotalPrice lowestTotalByBrand = priceService.findLowestTotalByBrand();
        return CommonResponse.success(priceControllerMapper.toResponse(lowestTotalByBrand));
    }

    @GetMapping("/categories/{categoryName}/range")
    public CommonResponse<CategoryPriceRangeResponse> findRangeByCategory(@PathVariable String categoryName) {
        CategoryPriceRange priceRangeByCategory = priceService.findPriceRangeByCategory(categoryName);
        return CommonResponse.success(priceControllerMapper.toResponse(priceRangeByCategory));
    }

    @GetMapping("/batch")
    public CommonResponse<Void> batch() {
        summaryBatchService.refreshSummaries();
        return CommonResponse.success(null);
    }

}
