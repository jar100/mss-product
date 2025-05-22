package com.jar100.mssproduct.config;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class CommonMapperConfig {
}
