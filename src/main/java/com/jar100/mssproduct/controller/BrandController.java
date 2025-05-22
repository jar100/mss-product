package com.jar100.mssproduct.controller;

import com.jar100.mssproduct.common.dto.CommonResponse;
import com.jar100.mssproduct.controller.dto.BrandCreateRequest;
import com.jar100.mssproduct.controller.dto.BrandDto;
import com.jar100.mssproduct.controller.dto.BrandUpdateRequest;
import com.jar100.mssproduct.controller.mapper.BrandControllerMapper;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.service.BrandService;
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

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService service;
    private final BrandControllerMapper mapper;

    @PostMapping
    public CommonResponse<BrandDto> create(@RequestBody @Valid BrandCreateRequest request) {
        BrandInfo info = service.create(mapper.toDto(request));
        return CommonResponse.success(mapper.toResponse(info));
    }

    @PutMapping("/{id}")
    public CommonResponse<BrandDto> update(@PathVariable Long id, @RequestBody @Valid BrandUpdateRequest request
    ) {
        BrandInfo info = service.update(mapper.toDto(id, request));
        return CommonResponse.success(mapper.toResponse(info));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return CommonResponse.success();
    }

    @GetMapping
    public CommonResponse<List<BrandDto>> listAll() {
        List<BrandInfo> list = service.listAll();
        List<BrandDto> resp = list.stream()
            .map(mapper::toResponse)
            .toList();
        return CommonResponse.success(resp);
    }
}
