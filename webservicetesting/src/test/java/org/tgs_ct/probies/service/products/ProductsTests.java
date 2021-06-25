package org.tgs_ct.probies.service.products;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ProductsTests {

    private static final String PASSED = "";

    @Test
    public void smoke() {
        ProductsResponseExpected expected = ProductsResponseExpected.getInstance();
        ProductsResponse actual = ProductsRequest.getInstance().get();
        String calibration = ProductsResponseCalibrator.getInstance(expected, actual).calibrate();
        Assert.assertEquals(calibration, PASSED);
    }
}
