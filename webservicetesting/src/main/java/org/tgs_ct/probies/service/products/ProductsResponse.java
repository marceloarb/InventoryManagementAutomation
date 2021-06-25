package org.tgs_ct.probies.service.products;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.tgs_ct.probies.inventory.data.Product;
import org.tgs_ct.probies.inventory.data.ProductCalibratable;

import javax.ws.rs.core.Response;
import java.util.List;

public class ProductsResponse implements ProductsResponseCalibratable {
    private final Integer status;
    private final String body;

    private ProductsResponse(Response response) {
        this.status = response != null ? response.getStatus() : null;
        body = response != null ? response.readEntity(String.class) : null;

    }

    public static ProductsResponse getInstance(Response response) {
        return new ProductsResponse(response);
    }

    @Override
    public Integer getStatusCode() {
        return status;
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        Gson gson = new Gson();
        List<ProductCalibratable> products = gson.fromJson(body, new TypeToken<List<Product>>() {}.getType());
        return products;
    }
}