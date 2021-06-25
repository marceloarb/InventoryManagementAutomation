package org.tgs_ct.probies.view.products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.tgs_ct.probies.ProductsView;
import org.tgs_ct.probies.ProductsViewCalibrator;
import org.tgs_ct.probies.ProductsViewExpected;

public class ProductsSteps {
    private static final String PASSED = "";
    ProductsViewExpected expected;
    ProductsView actual;

    @Given("^any scenario$")
    public void any_scenario() {
        expected = ProductsViewExpected.getInstance();
    }

    @When("^homepage is loaded$")
    public void homepage_is_loaded() {
        actual = ProductsView.directNav();
    }

    @Then("^all products all displayed$")
    public void all_products_all_displayed() {
        String calibration = ProductsViewCalibrator.getInstance(expected, actual).calibrate();
        Assert.assertEquals(calibration, PASSED);
    }

}
