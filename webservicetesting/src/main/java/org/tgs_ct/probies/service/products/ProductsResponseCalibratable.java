package org.tgs_ct.probies.service.products;


import org.tgs_ct.probies.inventory.data.ProductCalibratable;

import java.util.List;

public interface ProductsResponseCalibratable {
    int SUCCESS = 200;

    Integer getStatusCode();

    List<ProductCalibratable> getProducts();
}
