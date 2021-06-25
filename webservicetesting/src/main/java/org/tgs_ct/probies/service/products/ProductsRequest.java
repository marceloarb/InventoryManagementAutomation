package org.tgs_ct.probies.service.products;


import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class ProductsRequest {
    private static final String PATH = "http://localhost:8080/products";
    @SuppressWarnings("FieldCanBeLocal")
    private final Client client;
    private final WebTarget target;

    private ProductsRequest() {
        client = ClientBuilder.newBuilder()
                .build();
        target = client.target(UriBuilder.fromPath(PATH));
    }

    public static ProductsRequest getInstance() {
        return new ProductsRequest();
    }

    public ProductsResponse get() {
        Response response = null;
        try {
            response = target.request().get();
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass().getName()).warn(String.format("WARNING:  Unable to complete request to %s", PATH));
            e.printStackTrace();
        }
        ProductsResponse productResponse = ProductsResponse.getInstance(response);
        if (response != null) {
            response.close();
        }
        return productResponse;
    }
}
