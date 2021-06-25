package org.tgs_ct.probies;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UiHost {
    private static final String DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private static final String EXCEPTION_MESSAGE =
            "This exception may be caused by lack of dependency on 'guava', an implicit dependency of chromedriver.exe";
    private static UiHost uiHost;
    private ChromeDriver driver;

    private UiHost() {
    }

    public static UiHost getInstance() {
        if (uiHost == null) {
            uiHost = new UiHost();
        }
        return uiHost;
    }

    private ChromeDriver getDriver() {
        if (driver == null) {
            driver = instantiateDriver();
        }
        return driver;
    }

    private ChromeDriver instantiateDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeDriver aDriver = null;
        try {
            aDriver = new ChromeDriver();
        } catch (NoSuchMethodError e) {
            LogManager.getLogger(ProductsView.class).error(EXCEPTION_MESSAGE);
            e.printStackTrace();
        }
        return aDriver;
    }

    public void load(String url) {
        getDriver().get(url);
    }

    public WebElement findElement(By locator) {
        List<WebElement> elements = getDriver().findElements(locator);
        return elements.size() == 0 ? null : elements.get(0);
    }

    public void close() {
        driver.quit();
        driver = null;
    }

    public void waitUntilVisible(By locator) {
        int count = 0;
        boolean found = false;
        while (!found && count < 10) {
            //noinspection CatchMayIgnoreException
            try {
                found = UiHost.getInstance().findElement(locator).isDisplayed();
            } catch (Exception e) {
            }
            waitOneSecond();
            count += 1;
        }
        LogManager.getLogger(this.getClass().getName()).warn("Unable to confirm the state of the 'Products' view");
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }
}
