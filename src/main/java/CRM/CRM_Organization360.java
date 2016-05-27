package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Organization360 {

    WebDriver driver;

    public CRM_Organization360(WebDriver driver)
    {
        this.driver = driver;
    }

    //Tabs
    By TabGeneral = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[1]/a/span/span/span");
    By TabFinancial = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[2]/a/span/span/span");
    By TabEngagement = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[3]/a/span/span/span");
    By TabMembership = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[4]/a/span/span/span");
    By TabFundraising = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[5]/a/span/span/span");
    By TabAwards = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[6]/a/span/span/span");
    By TabExhibits = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[7]/a/span/span/span");
    By TabAdvertising = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[8]/a/span/span/span");

    //General Tab
    By EditThisOrganization = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[1]/a");

    //Financial Tab
    By ReceivePayment = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[1]/a");
    By CreateAnOrder = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[2]/a");

    //General Tab
    public void clickEditThisOrganization()
    {
        driver.findElement(TabGeneral).click();
        driver.findElement(EditThisOrganization).click();
    }

    public void clickReceivePayment()
    {
        driver.findElement(TabFinancial).click();
        driver.findElement(ReceivePayment).click();
    }

    public void clickCreateAnOrder()
    {
        driver.findElement(TabFinancial).click();
        driver.findElement(CreateAnOrder).click();
    }

}
