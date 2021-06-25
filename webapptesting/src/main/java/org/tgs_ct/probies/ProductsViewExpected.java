package org.tgs_ct.probies;

import org.tgs_ct.probies.inventory.data.ProductCalibratable;
import org.tgs_ct.probies.inventory.data.ProductProvider;

import java.util.List;

public class ProductsViewExpected implements ProductsViewCalibratable {
    private static final String LABEL = "Product name";

    private ProductsViewExpected() {
    }

    public static ProductsViewExpected getInstance() {
        return new ProductsViewExpected();
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        return ProductProvider.getInstance().getProducts();
    }

    @Override
    public String getLabel() {
        return LABEL;
    }
}
