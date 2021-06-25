package org.tgs_ct.probies;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tgs_ct.probies.repository.ProductRepository;
import org.tgs_ct.probies.service.Product;
import org.tgs_ct.probies.service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void testGetAllProducts_fromRepo() {
        BigDecimal productPrice1 = new BigDecimal("99.99");
        MockitoAnnotations.initMocks(this);
        List<Product> expectedProductList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(expectedProductList);
        Product product1 = new Product(1, "HP Laptop", productPrice1);
        expectedProductList.add(product1);
        Iterable<Product> actualProductList = productService.getAllProducts();
        Assert.assertEquals(expectedProductList, actualProductList);
    }
}
