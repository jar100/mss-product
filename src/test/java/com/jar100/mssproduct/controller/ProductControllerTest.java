package com.jar100.mssproduct.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jar100.mssproduct.controller.dto.ProductCreateRequest;
import com.jar100.mssproduct.controller.dto.ProductUpdateRequest;
import com.jar100.mssproduct.domain.product.dto.Category;
import com.jar100.mssproduct.domain.product.dto.ProductCreation;
import com.jar100.mssproduct.domain.product.dto.ProductInfo;
import com.jar100.mssproduct.domain.product.dto.ProductUpdate;
import com.jar100.mssproduct.domain.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductService productService;

    @Test
    void createProduct_shouldReturnSuccessResponse() throws Exception {
        ProductCreateRequest req = new ProductCreateRequest("P1", 1L, Category.TOP, 1000);
        ProductInfo info = ProductInfo.builder()
            .id(5L)
            .name("P1")
            .brandId(1L)
            .category(Category.TOP)
            .price(1000)
            .build();
        when(productService.create(any(ProductCreation.class))).thenReturn(info);

        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data.id").value(5))
            .andExpect(jsonPath("$.data.name").value("P1"))
            .andExpect(jsonPath("$.data.category").value("TOP"));
    }

    @Test
    void updateProduct_shouldReturnSuccessResponse() throws Exception {
        ProductUpdateRequest req = new ProductUpdateRequest(5L, "P2", 2L, Category.PANTS, 2000);
        ProductInfo info = ProductInfo.builder()
            .id(5L)
            .name("P2")
            .brandId(2L)
            .category(Category.PANTS)
            .price(2000)
            .build();
        when(productService.update(any(ProductUpdate.class))).thenReturn(info);

        mockMvc.perform(put("/api/v1/products/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"))
            .andExpect(jsonPath("$.data.name").value("P2"));
    }

    @Test
    void deleteProduct_shouldReturnSuccessResponse() throws Exception {
        doNothing().when(productService).delete(5L);

        mockMvc.perform(delete("/api/v1/products/5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("SUCCESS"));
    }
}