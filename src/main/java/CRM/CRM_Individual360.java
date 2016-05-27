package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_Individual360 {

    WebDriver driver;

    public CRM_Individual360(WebDriver driver)
    {
        this.driver = driver;
    }

    //Tabs
    By TabGeneral = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[1]/a/span/span/span");
    By TabDemographics = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[2]/a/span/span/span");
    By TabFinancial = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[3]/a/span/span/span");
    By TabEngagement = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[4]/a/span/span/span");
    By TabMembership = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[5]/a/span/span/span");
    By TabEvents = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[6]/a/span/span/span");
    By TabFundraising = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[7]/a/span/span/span");
    By TabAwards = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[8]/a/span/span/span");
    By TabRealtor_NRDS = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[9]/a/span/span/span");
    By Volunteers = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[10]/a/span/span/span");
    By TabSecurityAndAuditing = By.xpath(".//*[@id='ctl00_body_tsTabs']/div/ul/li[11]/a/span/span/span");

    By Xpath = By.xpath("//span/span/span[.='{0}']");

    //General Tab
    By EditThisIndividual = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[1]/a");
    By EditCommunicationPreferences = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[2]/a");
    By MergeThisIndividual = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[3]/a");
    By DeleteThisIndividual = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[4]/a");
    By ReportCenter_GT = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[5]/a");
    By SendAnEmail = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[6]/a");
    By LinkAnOrganziation = By.xpath(".//*[@id='ctl00_body_GeneralPanel']/table/tbody/tr/td[3]/div/ul/li[7]/a");

    //Financial Tab
    By ReceivePayment = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[1]/a");
    By CreateAnOrder = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[2]/a");
    By ApplyCredit = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[3]/a");
    By RecordAHistoricalTransaction = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[4]/a");
    By ReportCenter_FT = By.xpath(".//*[@id='ctl00_body_FinancialPanel']/table/tbody/tr/td[3]/div/ul/li[5]/a");


    //General Tab

    public void clickEditThisIndividual()
    {
        driver.findElement(TabGeneral).click();
        driver.findElement(EditThisIndividual).click();
    }

    //Financial Tab
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

    public void clickTab(String _tabName)
    {
        if (_tabName.equals("General"))
        {
            driver.findElement(TabGeneral).click();
        }

        if (_tabName.equals("Demographics"))
        {
            driver.findElement(TabDemographics).click();
        }

        if (_tabName.equals("Financial"))
        {
            driver.findElement(TabDemographics).click();
        }
    }

}
