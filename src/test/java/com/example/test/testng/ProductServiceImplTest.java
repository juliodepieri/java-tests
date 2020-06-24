package com.example.test.testng;

import com.example.test.product.Product;
import com.example.test.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;


@SpringBootTest
class ProductServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProductService productService;

    @Test
    void Create_NewProductWithoutIdInformed_ReturnsCreatedProductWithNewId() {
        var product = Product.builder()
                .name("product 1")
                .price(BigDecimal.valueOf(23.4))
                .build();
        product = productService.create(product);

        Assert.assertNotNull(product.getId(), "product should have returned with an ID");
    }

}
