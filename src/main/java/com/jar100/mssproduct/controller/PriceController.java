package com.jar100.mssproduct.controller;

import com.jar100.mssproduct.common.dto.CommonResponse;
import com.jar100.mssproduct.controller.dto.CategoryMinPriceResponse;
import com.jar100.mssproduct.controller.mapper.PriceControllerMapper;
import com.jar100.mssproduct.domain.price.service.PriceService;
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

    @GetMapping("/categories/lowest")
    public CommonResponse<List<CategoryMinPriceResponse>> findLowesByCategories() {

        //return CommonResponse.success(priceControllerMapper.toResponse(priceService.findLowestByCategories()))
        return null;
    }

    @GetMapping("/brands/lowest-total")
    public CommonResponse<List<CategoryMinPriceResponse>> findLowestByBrands() {
        //return CommonResponse.success(priceControllerMapper.toResponse(priceService.findLowestByBrands()));
        return null;
    }

    @GetMapping("/categories/{categoryName}/range")
    public CommonResponse<CategoryMinPriceResponse> findRangeByCategory(@PathVariable String categoryName) {
        //return CommonResponse.success(priceControllerMapper.toResponse(priceService.findRangeByCategory(categoryName)));
        return null;
    }

}
