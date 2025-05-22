package com.jar100.mssproduct.domain.product.service;

import com.jar100.mssproduct.common.exception.ProductNotFoundException;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import com.jar100.mssproduct.domain.product.mapper.ProductServiceMapper;
import com.jar100.mssproduct.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductServiceMapper productServiceMapper;

    @Override
    public ProductInfo create(ProductCreation creation) {
        ProductEntity entity = productServiceMapper.toEntity(creation);
        productRepository.save(entity);
        return productServiceMapper.toDto(entity);
    }

    @Override
    public ProductInfo findById(Long id) {
        ProductEntity entity = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
        return productServiceMapper.toDto(entity);
    }

    @Override
    public ProductInfo update(ProductUpdate productUpdate) {
        ProductEntity entity = productRepository.findById(productUpdate.id())
            .orElseThrow(() -> new ProductNotFoundException("Product not found: " + productUpdate.id()));
        entity.change(productUpdate);
        return productServiceMapper.toDto(productRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found: " + id);
        }
        productRepository.deleteById(id);
    }
}
