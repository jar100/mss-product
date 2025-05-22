package com.jar100.mssproduct.domain.brand.service;

import com.jar100.mssproduct.common.exception.BrandNotFoundException;
import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.dto.BrandUpdate;
import com.jar100.mssproduct.domain.brand.entity.BrandEntity;
import com.jar100.mssproduct.domain.brand.mapper.BrandServiceMapper;
import com.jar100.mssproduct.domain.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandServiceMapper brandMapper;

    @Override
    public BrandInfo create(BrandCreation creation) {
        BrandEntity entity = brandMapper.toEntity(creation);
        brandRepository.save(entity);
        return brandMapper.toDto(entity);
    }

    @Override
    public BrandInfo getBrand(Long brandId) {
        BrandEntity entity = brandRepository.findById(brandId)
            .orElseThrow(() -> new BrandNotFoundException("Brand not found: " + brandId));
        return brandMapper.toDto(entity);
    }

    @Override
    public BrandInfo update(BrandUpdate update) {
        BrandEntity entity = brandRepository.findById(update.id())
            .orElseThrow(() -> new BrandNotFoundException("Brand not found: " + update.id()));
        entity.changeName(update.name());
        return brandMapper.toDto(brandRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new BrandNotFoundException("Brand not found: " + id);
        }
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandInfo> listAll() {
        return brandRepository.findAll().stream()
            .map(brandMapper::toDto)
            .collect(Collectors.toList());
    }
}
