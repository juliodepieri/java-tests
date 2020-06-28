package com.example.test.junit;

import com.example.test.product.ProductController;
import com.example.test.product.ProductDto;
import com.example.test.product.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void Create_NewProductWithoutIdInformed_ReturnsStatusOk() throws Exception {
        ProductDto productDto = ProductDto.builder()
                .name("product 1")
                .price(BigDecimal.valueOf(2.54))
                .build();

        String json = objectMapper.writeValueAsString(productDto);

        this.mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"id\":1,\"name\":\"product 1\",\"price\":2.54}"));
    }

    @Test
    void Create_NewProductWithoutIdInformed_ThrowException() throws Exception {
        ProductDto productDto = ProductDto.builder()
                .name("product 1")
                .build();

        String json = objectMapper.writeValueAsString(productDto);

        this.mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

}
