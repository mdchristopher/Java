package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Home {

    WebDriver driver;

    public CRM_Home(WebDriver driver)
    {
        this.driver = driver;

    }

    By createAnIndividual = By.xpath(".//*[@id='ctl00_body_CRMTasks_Content']/table/tbody/tr[1]/td[1]/a/span[2]/span/span[1]");
    By createAnOrganization = By.xpath(".//*[@id='ctl00_body_CRMTasks_Content']/table/tbody/tr[2]/td[1]/a/span[2]/span/span[1]");


    public void clickCreateAnIndividual()
    {
        driver.findElement(createAnIndividual).click();
    }

    public void clickCreateAnOrganization()
    {
        driver.findElement(createAnOrganization).click();
    }

}
