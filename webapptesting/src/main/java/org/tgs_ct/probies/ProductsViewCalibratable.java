package org.tgs_ct.probies;

import org.tgs_ct.probies.inventory.data.ProductCalibratable;

import java.util.List;

public interface ProductsViewCalibratable {
    List<ProductCalibratable> getProducts();

    String getLabel();
}
