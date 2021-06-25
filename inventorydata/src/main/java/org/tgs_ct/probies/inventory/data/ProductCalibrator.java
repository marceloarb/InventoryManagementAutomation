package org.tgs_ct.probies.inventory.data;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Product";

    private ProductCalibrator(ProductExpected expected, Product actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static ProductCalibrator getInstance(ProductExpected expected, Product actual) {
        return new ProductCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
    }
}
