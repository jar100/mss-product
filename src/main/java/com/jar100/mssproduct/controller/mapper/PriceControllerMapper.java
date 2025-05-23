package com.jar100.mssproduct.controller.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;
import com.jar100.mssproduct.controller.dto.BrandTotalPriceResponse;
import com.jar100.mssproduct.controller.dto.CategoryMinPriceResponse;
import com.jar100.mssproduct.controller.dto.CategoryPriceRangeResponse;
import com.jar100.mssproduct.controller.dto.ProductCreateRequest;
import com.jar100.mssproduct.controller.dto.ProductDto;
import com.jar100.mssproduct.controller.dto.ProductUpdateRequest;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import com.jar100.mssproduct.domain.summary.dto.BrandTotalPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.dto.CategoryPriceRange;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface PriceControllerMapper {

    List<CategoryMinPriceResponse> toResponse(List<CategoryMinPrice> categoryMinPrices);

    CategoryMinPriceResponse toResponse(CategoryMinPrice categoryMinPrice);

    BrandTotalPriceResponse toResponse(BrandTotalPrice lowestTotalByBrand);

    CategoryPriceRangeResponse toResponse(CategoryPriceRange categoryPriceRange);
}
