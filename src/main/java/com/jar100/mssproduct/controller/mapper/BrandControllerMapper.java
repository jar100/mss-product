package com.jar100.mssproduct.controller.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;
import com.jar100.mssproduct.controller.dto.BrandCreateRequest;
import com.jar100.mssproduct.controller.dto.BrandResponse;
import com.jar100.mssproduct.controller.dto.BrandUpdateRequest;
import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.dto.BrandUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface BrandControllerMapper {
    BrandCreation toDto(BrandCreateRequest request);

    BrandUpdate toDto(Long id, BrandUpdateRequest request);

    BrandResponse toResponse(BrandInfo info);
}
