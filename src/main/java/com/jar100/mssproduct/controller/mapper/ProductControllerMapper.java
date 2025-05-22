package com.jar100.mssproduct.controller.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;

import com.jar100.mssproduct.controller.dto.ProductCreateRequest;
import com.jar100.mssproduct.controller.dto.ProductDto;
import com.jar100.mssproduct.controller.dto.ProductUpdateRequest;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface ProductControllerMapper {
    ProductCreation toDto(ProductCreateRequest request);

    ProductUpdate toDto(Long id, ProductUpdateRequest request);

    ProductDto toResponse(ProductInfo info);
}
