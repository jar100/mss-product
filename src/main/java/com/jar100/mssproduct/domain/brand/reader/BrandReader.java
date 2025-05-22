package com.jar100.mssproduct.domain.brand.reader;

import com.jar100.mssproduct.domain.brand.dto.BrandInfo;

public interface BrandReader {
    BrandInfo fetchById(Long id);
}
