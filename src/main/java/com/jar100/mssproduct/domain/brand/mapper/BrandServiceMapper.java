package com.jar100.mssproduct.domain.brand.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;
import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.entity.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface BrandServiceMapper {

    BrandInfo toDto(BrandEntity entity);

    BrandEntity toEntity(BrandCreation creation);
}
