package Console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsoleHome
{
        WebDriver driver;


        By CRMmodule = By.xpath(".//*[@id='ctl00_rmTopTabs']/ul/li[2]/a/span");
        By MembersModule = By.xpath(".//*[@id='ctl00_rmTopTabs']/ul/li[3]/a/span");


        public ConsoleHome(WebDriver driver)
        {
            this.driver = driver;

        }



        public void clickCRMmodule()
        {
            driver.findElement(CRMmodule).click();
        }

        public void clickMembersModule()
        {
            driver.findElement(MembersModule).click();
        }
}
