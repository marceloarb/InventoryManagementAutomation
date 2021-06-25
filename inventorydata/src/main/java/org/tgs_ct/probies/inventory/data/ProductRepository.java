package org.tgs_ct.probies.inventory.data;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductRepository {
    InputStream inputStream;

    public static ProductRepository getInstance() {
        return new ProductRepository();
    }

    public List<ProductCalibratable> query() {
        List<ProductCalibratable> products = null;
        try {
            Properties dbproperties = new Properties();
            String propFileName = "productsdb.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                dbproperties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String port = dbproperties.getProperty("port");
            String mySqlURL = String.format("jdbc:mysql://localhost:%s/inventory", port);
            String userName = "root";
            String password = dbproperties.getProperty("password");
            String select = "select a.id, a.name, a.price ";
            String from = "from product as a";
            String query = select + from;
            products = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(mySqlURL, userName, password)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    products.add(Product.getInstance(resultSet));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public ProductCalibratable query(ProductDefinition definition) {
        for (ProductCalibratable candidate : query()) {
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }
}
