package com.jar100.mssproduct.domain.brand.reader;

import com.jar100.mssproduct.common.exception.BrandNotFoundException;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BrandReaderImpl implements BrandReader {

    private final BrandRepository brandRepository;

    @Override
    public BrandInfo fetchById(Long id) {
        return brandRepository.findById(id)
                .map(brand -> BrandInfo.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .build())
                .orElseThrow(() -> new BrandNotFoundException("Brand not found with id: " + id));
    }
}
