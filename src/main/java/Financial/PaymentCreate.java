package Financial;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentCreate {

    WebDriver driver;

    public PaymentCreate(WebDriver driver)
    {
        this.driver = driver;
    }

    //Static Fields
    By PaymentMethod = By.id("ctl00_body_cbPaymentMethod_Input"); //Input
    By Amount = By.xpath(".//*[@id='ctl00_body_tbAmount']"); //Text
    By ProcessPaymentBtn = By.id("ctl00_body_lbSave");
    By PPSprocessPaymentBtn = By.xpath(".//*[@id='ctl00_body_pnlAjaxTransitions']/a[2]/span");

    //Dynamic Fields
    //CreditCard Fields
    By CreditCardNumber = By.xpath(".//*[@id='ctl00_body_tbCreditCardNumber']"); //Text
    By CardExpirationMonth = By.xpath(".//*[@id='ctl00_body_myExpiration_MonthDropDownList']"); //Select
    By CardExiprationYear = By.xpath(".//*[@id='ctl00_body_myExpiration']/select[2]"); //Select
    By CVVCode = By.xpath(".//*[@id='ctl00_body_tbCCV']"); //Select

    //eCheck Fields
    By BankAccountNumber = By.xpath(".//*[@id='ctl00_body_tbBankAccountNumber']"); //Text
    By RoutingAccountNumber = By.xpath(".//*[@id='ctl00_body_tbRoutingNumber']"); //Text
    By BankAccountType = By.xpath(".//*[@id='ctl00_body_cbBankAccountType_Input']"); //Input

    //Shared between CC and eCheck
    By MerchantAccount = By.xpath(".//*[@id='ctl00_body_cbMerchantAccount_Input']"); //Input


    By MessageBar = By.id("ctl00_divMessage");
    By SaveCreditCardOrEcheckForFutureUse = By.id("ctl00_body_cbSavePaymentMethod");

    public void selectPaymentMethod(String _paymentMethod)
    {
        driver.findElement(PaymentMethod).click();

        if (_paymentMethod.equals("Credit Card"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[1]")).click();
        }

        if (_paymentMethod.equals("Electronic Check"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[2]")).click();
        }

        if (_paymentMethod.equals("Other"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[11]")).click();
        }

    }
    public void typeAmount(String _amount)
    {
        driver.findElement(Amount).sendKeys(_amount);
    }


    //Credit Card
    public void typeCreditCardNumber(String _CCnumber)
    {
        driver.findElement(CreditCardNumber).sendKeys(_CCnumber);
    }
    public void selectCardExpirationMonth(String _CCexpMo)
    {
        WebElement element = driver.findElement(CardExpirationMonth);
        Select cardExpirationMonth = new Select(element);
        cardExpirationMonth.selectByVisibleText(_CCexpMo); //might need to do value
    }
    public void selectCardExpirationYear(String _CCexpYr)
    {
        WebElement element = driver.findElement(CardExiprationYear);
        Select cardExpirationYear = new Select(element);
        cardExpirationYear.selectByValue(_CCexpYr);
    }
    public void typeCCVcode(String _CCVcode)
    {
        driver.findElement(CVVCode).sendKeys(_CCVcode);
    }

    //Echeck
    public void typeBankAccountNumber(String _bankAccountNumber)
    {
        driver.findElement(BankAccountNumber).sendKeys(_bankAccountNumber);
    }
    public void typeRoutingAccountNumber(String _routingAccountNumber)
    {
        driver.findElement(RoutingAccountNumber).sendKeys(_routingAccountNumber);
    }

    //Shared
    public void checkSaveCreditCardOrEcheckForFutureUse()
    {
        driver.findElement(SaveCreditCardOrEcheckForFutureUse).click();
    }

    public void clickPPSprocessPaymentBtn()
    {
        driver.findElement(PPSprocessPaymentBtn).click();
    }

    //Other
    public void clickProcessPaymentBtn()
    {
        driver.findElement(ProcessPaymentBtn).click();
    }
    public void isPaymentSuccessful()
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(MessageBar));

        Assert.assertTrue(driver.getPageSource().contains("The payment was processed successfully."));
    }





}
