package com.example.test.product;

import com.example.test.exception.RegisterNotFoundException;
import com.example.test.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Autowired
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product create(Product product) {
        if (nonNull(product.getId()) && repo.existsById(product.getId())) {
            throw new ResourceAlreadyExistsException("ID is already registered");
        }
        return repo.save(product);
    }

    @Override
    public Product update(Product product) {
        if (isNull(product.getId())) {
            throw new IllegalArgumentException("Id was not informed");
        }

        if (!repo.existsById(product.getId())) {
            throw new RegisterNotFoundException("Register with this ID not found");
        }

        return repo.save(product);
    }

    @Override
    public void delete(Long id) {
        if (isNull(id)) {
            throw new IllegalArgumentException("Id was not informed");
        }

        if (!repo.existsById(id)) {
            throw new RegisterNotFoundException("Register with this ID not found");
        }

        repo.deleteById(id);
    }

}
