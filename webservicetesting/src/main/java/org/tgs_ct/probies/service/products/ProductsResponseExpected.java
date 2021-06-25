package org.tgs_ct.probies.service.products;

import org.tgs_ct.probies.inventory.data.ProductCalibratable;
import org.tgs_ct.probies.inventory.data.ProductProvider;

import java.util.List;

public class ProductsResponseExpected implements ProductsResponseCalibratable {

    private ProductsResponseExpected() {
    }

    public static ProductsResponseExpected getInstance() {
        return new ProductsResponseExpected();
    }

    @Override
    public Integer getStatusCode() {
        return SUCCESS;
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        return ProductProvider.getInstance().getProducts();
    }

}
