package com.jar100.mssproduct.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jar100.mssproduct.controller.dto.BrandCreateRequest;
import com.jar100.mssproduct.controller.dto.BrandUpdateRequest;
import com.jar100.mssproduct.domain.brand.dto.BrandCreation;
import com.jar100.mssproduct.domain.brand.dto.BrandInfo;
import com.jar100.mssproduct.domain.brand.dto.BrandUpdate;
import com.jar100.mssproduct.domain.brand.service.BrandService;
import com.jar100.mssproduct.domain.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BrandControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private BrandService brandService;

    @Test
    void createBrand_shouldReturnSuccessResponse() throws Exception {
        BrandCreateRequest req = new BrandCreateRequest("NewBrand");
        BrandInfo info = BrandInfo.builder()
            .id(1L)
            .name("NewBrand")
            .build();
        when(brandService.create(any(BrandCreation.class))).thenReturn(info);

        mockMvc.perform(post("/api/v1/brands")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data.id").value(1))
            .andExpect(jsonPath("$.data.name").value("NewBrand"));
    }

    @Test
    void updateBrand_shouldReturnUpdatedResponse() throws Exception {
        BrandUpdateRequest req = new BrandUpdateRequest("UpdatedBrand");
        BrandInfo info = BrandInfo.builder()
            .id(2L)
            .name("UpdatedBrand2")
            .build();
        when(brandService.update(any(BrandUpdate.class))).thenReturn(info);

        mockMvc.perform(put("/api/v1/brands/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data.id").value(2))
            .andExpect(jsonPath("$.data.name").value("UpdatedBrand2"));
    }

    @Test
    void deleteBrand_shouldReturnSuccessResponse() throws Exception {
        doNothing().when(brandService).delete(3L);

        mockMvc.perform(delete("/api/v1/brands/3"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void listAllBrands_shouldReturnBrandList() throws Exception {
        List<BrandInfo> infos = List.of(
            BrandInfo.builder().id(1L).name("A").build(),
            BrandInfo.builder().id(2L).name("B").build()
        );
        when(brandService.listAll()).thenReturn(infos);

        mockMvc.perform(get("/api/v1/brands"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data[0].id").value(1))
            .andExpect(jsonPath("$.data[0].name").value("A"))
            .andExpect(jsonPath("$.data[1].id").value(2))
            .andExpect(jsonPath("$.data[1].name").value("B"));
    }
}