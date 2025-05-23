package com.jar100.mssproduct.domain.product.service;

import com.jar100.mssproduct.common.dto.ProductChangedEvent;
import com.jar100.mssproduct.common.exception.ProductNotFoundException;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import com.jar100.mssproduct.domain.product.entity.ProductEntity;
import com.jar100.mssproduct.domain.product.mapper.ProductServiceMapper;
import com.jar100.mssproduct.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher publisher;
    private final ProductServiceMapper productServiceMapper;

    @Override
    public ProductInfo create(ProductCreation creation) {
        ProductEntity entity = productServiceMapper.toEntity(creation);
        productRepository.save(entity);
        //event publish 최저가 변경
        publisher.publishEvent(ProductChangedEvent.builder()
            .productId(entity.getId())
            .brandId(entity.getBrandId())
            .category(entity.getCategory())
            .price(entity.getPrice())
            .type(ProductChangedEvent.Type.CREATE)
            .build());
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

        //event publish 최저가 변경
        publisher.publishEvent(ProductChangedEvent.builder()
            .productId(entity.getId())
            .brandId(entity.getBrandId())
            .category(entity.getCategory())
            .price(entity.getPrice())
            .type(ProductChangedEvent.Type.UPDATE)
            .build());
        return productServiceMapper.toDto(productRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
        productRepository.deleteById(id);
        //event publish 최저가 변경
        publisher.publishEvent(ProductChangedEvent.builder()
            .productId(productEntity.getId())
            .brandId(productEntity.getBrandId())
            .category(productEntity.getCategory())
            .price(productEntity.getPrice())
            .type(ProductChangedEvent.Type.DELETE)
            .build());
    }
}
