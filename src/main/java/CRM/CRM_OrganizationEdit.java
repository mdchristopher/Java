package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

import java.util.List;

public class CRM_OrganizationEdit {

    WebDriver driver;

    public CRM_OrganizationEdit(WebDriver driver)
    {
        this.driver = driver;
    }

    // Need to find a way to identify the field "Name" then find the next input. ID will change if fields added to page layout
    //By Name = By.xpath(".//*[@id='ctl00_body_Basic_Content']/table/tbody/tr[1]/td[1]/following-sibling::td[1]/input");

    By Name = By.xpath(".//td/label[contains(text(), 'Name:')]/following:: td[1]/input");
    By BillingEmailAddress = By.xpath(".//td/label[contains(text(), 'Billing Email Address:')]/following:: td[1]/input");
    By MainPhoneNumber = By.xpath(".//td/label[contains(text(), 'Main Phone #:')]/following:: td[1]/input");

    By Save = By.xpath(".//*[@id='ctl00_body_lb_CheckForDuplicates']/span");
    By DefaultCreditTerms = By.xpath(".//td/label[contains(text(), 'Default Credit Terms:')]/following:: tr/td[1]/input");

    public void enterBasicInfo(String _name, String _billingEmailAddress, String _mainPhoneNumber)
    {
        driver.findElement(Name).clear();
        driver.findElement(Name).sendKeys(_name);

        driver.findElement(BillingEmailAddress).clear();
        driver.findElement(BillingEmailAddress).sendKeys(_billingEmailAddress);

        driver.findElement(MainPhoneNumber).clear();
        driver.findElement(MainPhoneNumber).sendKeys(_mainPhoneNumber);

    }

    public void typeName(String _name)
    {
        driver.findElement(Name).sendKeys(_name);
    }

    public void typeBillingEmailAddress(String _billingEmailAddress)
    {
        driver.findElement(BillingEmailAddress).sendKeys(_billingEmailAddress);
    }

    public void typeMainPhoneNumber(String _mainPhoneNumber)
    {
        driver.findElement(MainPhoneNumber).sendKeys(_mainPhoneNumber);
    }

    public void clickSave()
    {
        driver.findElement(Save).click();
    }

    public void inputDefaultCreditTerms(String _defaultCreditTerms)
    {
        driver.findElement(DefaultCreditTerms).click();

        if(_defaultCreditTerms.equals("Net90"))
        {
            driver.findElement(By.xpath("//li[.='Net90']")).click();
        }

        if(_defaultCreditTerms.equals("Net60"))
        {
            driver.findElement(By.xpath("//li[.='Net60']")).click();
        }

        if(_defaultCreditTerms.equals("Net30"))
        {
            driver.findElement(By.xpath("//li[.='Net30']")).click();
        }

        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='ctl00_body_RadComboBox26_DropDown']/div/ul/li[4]"))));

        //new Select((WebElement) DefaultCreditTerms).selectByVisibleText(_defaultCreditTerms);
        //element.sendKeys(_defaultCreditTerms);

        //WebElement element = driver.findElement(CreditTermsDropDown);
        //Select creditDropDown = new Select(element);
        //creditDropDown.selectByVisibleText(_defaultCreditTerms);

    }
}
