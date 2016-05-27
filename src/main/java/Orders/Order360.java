package Orders;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order360 {

    WebDriver driver;

    public Order360(WebDriver driver)
    {
        this.driver = driver;
    }

    By MessageBar = By.id("ctl00_divMessage");




    public void isOrderSuccessful()
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(MessageBar));

        Assert.assertTrue(driver.getPageSource().contains("Order has been processed successfully"));

    }
}
