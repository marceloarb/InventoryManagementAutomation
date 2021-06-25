package org.tgs_ct.probies;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductsViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Products' view";
    private final ProductsView actual;
    private final ProductsViewExpected expected;

    private ProductsViewCalibrator(ProductsViewExpected expected, ProductsView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static ProductsViewCalibrator getInstance(ProductsViewExpected expected, ProductsView actual) {
        return new ProductsViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Products' label", expected.getLabel(), actual.getLabel());
        verify("'Products' list", expected.getProducts(), actual.getProducts());
    }
}
