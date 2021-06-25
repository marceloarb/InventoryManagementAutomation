package org.tgs_ct.probies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tgs_ct.probies.repository.ProductRepository;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
