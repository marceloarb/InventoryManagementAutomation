package org.tgs_ct.probies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tgs_ct.probies.service.Product;
import org.tgs_ct.probies.service.ProductService;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins= {"http://localhost:3000"})
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public Iterable<Product> getAllProducts() throws IOException {
        return productService.getAllProducts();
    }
}
