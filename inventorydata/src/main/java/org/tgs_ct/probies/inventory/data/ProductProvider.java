package org.tgs_ct.probies.inventory.data;

import java.util.List;

public class ProductProvider {

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public List<ProductCalibratable> getProducts() {
        return ProductRepository.getInstance().query();
    }


    public Product get(ProductDefinition definition) {
        return (Product) ProductRepository.getInstance().query(definition);
    }
}
