package org.tgs_ct.probies.service.products;

import com.softwareonpurpose.calibrator4test.Calibrator;
import org.tgs_ct.probies.inventory.data.ProductCalibratable;

import java.util.List;

public class ProductsResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' response";
    private final ProductsResponseExpected expected;
    private final ProductsResponse actual;

    private ProductsResponseCalibrator(ProductsResponseExpected expected, ProductsResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductsResponseCalibrator getInstance(ProductsResponseExpected expected, ProductsResponse actual) {
        return new ProductsResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Status Code", expected.getStatusCode(), actual.getStatusCode());
        verifyProducts();
    }

    private void verifyProducts() {
        List<ProductCalibratable> actualProducts = actual.getProducts();
        int indexZero = 0;
        for (ProductCalibratable expectedProduct : expected.getProducts()) {
            ProductCalibratable actualProduct = actualProducts.size() > 0 ? actualProducts.get(indexZero) : null;
            verify("Product", expectedProduct, actualProduct);
            if (actualProduct != null) {
                actualProducts.remove(actualProduct);
            }
        }
        for (ProductCalibratable actualProduct : actualProducts) {
            verify("Product", null, actualProduct);
        }
    }
}
