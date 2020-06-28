package com.example.test.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.create(productDto.toEntity()).toDto(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") Long id, @RequestBody @Valid ProductDto productDto) {
        productDto.setId(id);
        Product product = productService.update(productDto.toEntity());
        return ResponseEntity.ok(product.toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
