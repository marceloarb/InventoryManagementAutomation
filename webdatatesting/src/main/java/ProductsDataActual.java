import java.util.List;

public class ProductsDataActual implements ProductsDataCalibratable {

    public static ProductsDataActual getInstance() {
        return new ProductsDataActual();
    }

    @Override
    public List<Products> getProducts() {
        return null;
    }
}
