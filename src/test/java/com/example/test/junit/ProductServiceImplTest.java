package com.example.test.junit;

import com.example.test.product.Product;
import com.example.test.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void Create_NewProductWithoutIdInformed_ReturnsCreatedProductWithNewId() {
        var product = Product.builder()
                .name("product 1")
                .price(BigDecimal.valueOf(23.4))
                .build();
        product = productService.create(product);

        assertNotNull(product.getId(), "product should have returned with an ID");
    }

}
