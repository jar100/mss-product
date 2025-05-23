package com.jar100.mssproduct.domain.brand.service;

import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.dto.BrandUpdate;

import java.util.List;

public interface BrandService {

    BrandInfo create(BrandCreation brandCreation);

    BrandInfo getBrand(Long brandId);

    BrandInfo update(BrandUpdate update);

    void delete(Long brandId);

    List<BrandInfo> listAll();

    BrandInfo findBy(Long id);
}
