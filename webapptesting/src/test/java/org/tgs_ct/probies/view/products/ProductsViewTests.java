package org.tgs_ct.probies.view.products;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.tgs_ct.probies.ProductsView;
import org.tgs_ct.probies.ProductsViewCalibrator;
import org.tgs_ct.probies.ProductsViewExpected;
import org.tgs_ct.probies.UiHost;

@Test
public class ProductsViewTests {
    private static final String PASSED = "";

    @Test(groups = {"smoke", "acceptance", "release"}, enabled = false)
    public void smoke() {
        ProductsViewExpected expected = ProductsViewExpected.getInstance();
        ProductsView actual = ProductsView.directNav();
        String calibration = ProductsViewCalibrator.getInstance(expected, actual).calibrate();
        Assert.assertEquals(calibration, PASSED);
    }

    @AfterMethod(alwaysRun = true)
    private void terminate() {
        UiHost.getInstance().close();
    }
}
