import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductsDataCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Products Data";
    private final ProductsDataExpected expected;
    private final ProductsDataActual actual;

    private ProductsDataCalibrator(ProductsDataExpected expected, ProductsDataActual actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductsDataCalibrator getInstance(ProductsDataExpected expected, ProductsDataActual actual) {
        return new ProductsDataCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify(DESCRIPTION, expected.getProducts(), actual.getProducts());
    }
}
