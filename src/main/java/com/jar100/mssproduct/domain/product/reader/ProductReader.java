package com.jar100.mssproduct.domain.product.reader;

import com.jar100.mssproduct.domain.product.dto.ProductInfo;

public interface ProductReader {
    ProductInfo fetchById(Long id);
}
