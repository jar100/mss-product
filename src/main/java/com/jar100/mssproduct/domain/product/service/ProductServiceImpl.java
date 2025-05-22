package com.jar100.mssproduct.domain.product.service;

import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductSearchCriteria;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductInfo create(ProductCreation creation) {
        return null;
    }

    @Override
    public ProductInfo findById(Long id) {
        return null;
    }

    @Override
    public ProductInfo update(ProductUpdate productInfo) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ProductInfo> search(ProductSearchCriteria criteria) {
        return List.of();
    }
}
