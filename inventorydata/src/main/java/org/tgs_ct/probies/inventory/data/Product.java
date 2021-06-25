package org.tgs_ct.probies.inventory.data;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product extends ProductCalibratable {
    private Product(ResultSet resultSet) {
        try {
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            price = resultSet.getBigDecimal("price");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Product getInstance(ResultSet productData) {
        return new Product(productData);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
