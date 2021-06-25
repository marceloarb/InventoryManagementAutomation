package org.tgs_ct.probies.inventory.data;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ProductProviderTests {
    private static final String  PASSED = "";

    @Test
    public void smoke(){
        ProductExpected expected = ProductExpected.getInstance();
        ProductDefinition definition = ProductDefinition.getInstance();
        Product actual = ProductProvider.getInstance().get(definition);
        String calibration = ProductCalibrator.getInstance(expected, actual).calibrate();
        Assert.assertEquals(calibration, PASSED);
    }
}
