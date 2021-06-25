package org.tgs_ct.probies.data;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.tgs_ct.probies.inventory.data.ProductCalibratable;

import java.math.BigDecimal;

public class ProductUi extends ProductCalibratable {
    private ProductUi(WebElement productElement) {
        By nameLocator = new By.ByClassName("product-name");
        name = productElement.findElement(nameLocator).getText();
        name = name.equals("[unknown]") ? null : name;

        By idLocator = new By.ByClassName("product-id");
        id = Integer.parseInt(productElement.findElement(idLocator).getText());

        By priceLocator = new By.ByClassName("product-price");
        String tempPrice = productElement.findElement(priceLocator).getText(); // $ 9,999.99
        price = tempPrice.equals("AVAILABLE SOON") ? null : priceFormatEditor(tempPrice);

    }

    private BigDecimal priceFormatEditor(String price) {
        BigDecimal editedPrice =  new BigDecimal(price.replace("$", " ").replace(",", "").trim());
        return editedPrice;
    }

    public static ProductUi getInstance(WebElement productElement) {
        return new ProductUi(productElement);
    }

    String getName() {
        return name;
    }

    Integer getId() {
        return id;
    }

    BigDecimal getPrice() {
        return price;
    }

    public String toString() {
        return (new Gson()).toJson(this);
    }
}
