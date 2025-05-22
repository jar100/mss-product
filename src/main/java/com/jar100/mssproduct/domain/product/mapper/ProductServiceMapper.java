package com.jar100.mssproduct.domain.product.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface ProductServiceMapper {
    ProductInfo toDto(ProductEntity entity);

    ProductEntity toEntity(ProductCreation creation);
}
