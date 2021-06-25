import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsDataTest {
    private static final String PASSED = "";

    @Test
    public void smoke() {
        ProductsDataExpected expected = ProductsDataExpected.getInstance();
        ProductsDataActual actual = ProductsDataActual.getInstance();
        String calibration = ProductsDataCalibrator.getInstance(expected, actual).calibrate();
        Assert.assertEquals(calibration, PASSED);
    }
}
