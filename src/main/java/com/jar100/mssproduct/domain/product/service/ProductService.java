package com.jar100.mssproduct.domain.product.service;

import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;

public interface ProductService {
    ProductInfo create(ProductCreation creation);

    ProductInfo findById(Long id);

    ProductInfo update(ProductUpdate productInfo);

    void delete(Long id);
}
