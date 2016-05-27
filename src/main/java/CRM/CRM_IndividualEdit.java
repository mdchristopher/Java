package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_IndividualEdit {

    WebDriver driver;

    public CRM_IndividualEdit(WebDriver driver)
    {
        this.driver = driver;
    }

    By FirstName = By.xpath(".//td/label[contains(text(), 'First Name')]/following:: td[1]/input");
    By LastName = By.xpath(".//td/label[contains(text(), 'Last Name')]/following:: td[1]/input");
    By EmailAddress = By.xpath(".//td/label[contains(text(), 'Email Address')]/following:: td[1]/input");
    By Save = By.xpath(".//*[@id='ctl00_body_lb_CheckForDuplicates']/span");
    By MainPhoneNumber = By.xpath(".//td/label[contains(text(), 'Main Phone #')]/following:: td[1]/input");

    public void typeFirstName(String _firstName)
    {
        driver.findElement(FirstName).sendKeys(_firstName);
    }

    public void typeLastName(String _LastName)
    {
        driver.findElement(LastName).sendKeys(_LastName);
    }

    public void typeEmailAddress(String _EmailAddress)
    {
        driver.findElement(EmailAddress).sendKeys(_EmailAddress);
    }

    public void clickSave()
    {
        driver.findElement(Save).click();
    }

    public void typeMainPhoneNumber(String _mainPhoneNumber)
    {
        driver.findElement(MainPhoneNumber).clear();
        driver.findElement(MainPhoneNumber).sendKeys(_mainPhoneNumber);
    }

    public void enterBasicInfo(String firstName, String lastName, String emailAddress, String mainPhoneNumber)
    {
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys(firstName);

        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys(lastName);

        driver.findElement(EmailAddress).clear();
        driver.findElement(EmailAddress).sendKeys(emailAddress);

        driver.findElement(MainPhoneNumber).clear();
        driver.findElement(MainPhoneNumber).sendKeys(mainPhoneNumber);
    }

}