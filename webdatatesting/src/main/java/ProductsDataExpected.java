import java.util.List;

public class ProductsDataExpected implements ProductsDataCalibratable {
    public static ProductsDataExpected getInstance() {
        return new ProductsDataExpected();
    }

    @Override
    public List<Products> getProducts() {
        return null;
    }
}
