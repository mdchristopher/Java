package Console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

WebDriver driver;


    By signOut = By.xpath(".//*[@id='userNavTopContainer']/ul/li[7]/a");


    public Header(WebDriver driver)
    {
        this.driver = driver;
    }


    public void clickSignOut()
    {
        driver.findElement(signOut).click();
    }

}
