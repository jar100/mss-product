package com.jar100.mssproduct.controller;

import com.jar100.mssproduct.common.dto.CommonResponse;
import com.jar100.mssproduct.controller.dto.ProductCreateRequest;
import com.jar100.mssproduct.controller.dto.ProductDto;
import com.jar100.mssproduct.controller.dto.ProductUpdateRequest;
import com.jar100.mssproduct.controller.mapper.ProductControllerMapper;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ProductControllerMapper mapper;

    @PostMapping
    public CommonResponse<ProductDto> create(@RequestBody @Valid ProductCreateRequest request) {
        ProductInfo info = productService.create(mapper.toDto(request));
        return CommonResponse.success(mapper.toResponse(info));
    }

    @GetMapping("/{id}")
    public CommonResponse<ProductDto> findById(@PathVariable Long id) {
        ProductInfo info = productService.findById(id);
        return CommonResponse.success(mapper.toResponse(info));
    }

    @PutMapping("/{id}")
    public CommonResponse<ProductDto> update(@PathVariable Long id, @RequestBody @Valid ProductUpdateRequest request) {
        ProductInfo info = productService.update(mapper.toDto(id, request));
        return CommonResponse.success(mapper.toResponse(info));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return CommonResponse.success();
    }
}
