package com.example.test.product;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);

}
