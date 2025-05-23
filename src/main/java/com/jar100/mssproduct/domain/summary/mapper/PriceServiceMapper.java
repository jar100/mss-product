package com.jar100.mssproduct.domain.summary.mapper;

import com.jar100.mssproduct.config.CommonMapperConfig;
import com.jar100.mssproduct.domain.summary.dto.CategoryMinPrice;
import com.jar100.mssproduct.domain.summary.entity.CategoryPriceSummaryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
    config = CommonMapperConfig.class)
public interface PriceServiceMapper {

    CategoryMinPrice toCategoryMinPrice(CategoryPriceSummaryEntity entity);
}
