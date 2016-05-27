package Orders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderCreate {

    WebDriver driver;

    public OrderCreate (WebDriver driver)
    {
        this.driver = driver;
    }

    //Items
    By AddFirstProductToThisOrder = By.xpath(".//*[@id='ctl00_body_rgItems_ctl00_ctl04_cbProduct_Input']");

    //Payment Information
    By PaymentInforamtion = By.id("ctl00_body_cbPaymentMethod_Input");
    By GenerateProFormaInvoiceForThisOrder = By.id("ctl00_body_cbProForma");
    By SuppressConfirmaitonEmail = By.id("ctl00_body_cbSuppressConfirmationEmails");

    //Credit Card Information
    By CardNumber = By.id("ctl00_body_tbCreditCardNumber");
    By CardExpirationMonth = By.xpath(".//*[@id='ctl00_body_myExpiration_MonthDropDownList']"); //select
    By CardExpirationYear = By.xpath(".//*[@id='ctl00_body_myExpiration']/select[2]"); //select
    By CCVCode = By.xpath(".//*[@id='ctl00_body_tbCCV']");

    //Electronic Check
    By BankAccountNumber = By.xpath(".//*[@id='ctl00_body_tbBankAccountNumber']"); //Text
    By RoutingAccountNumber = By.xpath(".//*[@id='ctl00_body_tbRoutingNumber']"); //Text
    By BankAccountType = By.xpath(".//*[@id='ctl00_body_cbBankAccountType_Input']"); //Input

    //Buttons
    By ApplyButton = By.xpath(".//*[@id='ctl00_body_lbApplyCoupon']/span");
    By ProcessOrderButton = By.xpath(".//*[@id='buttonsDiv']/a[2]/span");
    By CancelButton = By.xpath(".//*[@id='ctl00_body_lbCancel']/span");

    //Line Items
    By FirstLineItemGearIcon = By.xpath(".//*[@id='ctl00_body_rgItems_ctl00_ctl04_hlEdit']");
    By FirstLineItemDeleteIcon = By.xpath(".//*[@id='ctl00_body_rgItems_ctl00_ctl04_lbDelete']");

    public void selectPaymentMethod(String _paymentMethod)
    {
        driver.findElement(PaymentInforamtion).click();

        if (_paymentMethod.equals("No Payment"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[1]")).click();
        }

        if (_paymentMethod.equals("Credit Card"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[2]")).click();
        }

        if (_paymentMethod.equals("Electronic Check"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[3]")).click();
        }

        if (_paymentMethod.equals("Saved Payment Method"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[4]")).click();
        }

        if (_paymentMethod.equals("Cash"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[5]")).click();
        }

        if (_paymentMethod.equals("Check"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[6]")).click();
        }

        //finish these lesser used payment methods later

        if (_paymentMethod.equals("Other"))
        {
            driver.findElement(By.xpath(".//*[@id='ctl00_body_cbPaymentMethod_DropDown']/div/ul/li[11]")).click();
        }
    }

    //This should search for the string that is passed in and wait until that the element is visible based on the string name
    public void addFirstLineItem(String _firstLineItemName) //this will only work for 1 line item(the first) figure out how to add multiple
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(AddFirstProductToThisOrder).click();
        driver.findElement(AddFirstProductToThisOrder).clear();
        driver.findElement(AddFirstProductToThisOrder).sendKeys(_firstLineItemName);

        By xpathContainsString = By.xpath("//span[contains(text(),'"+(_firstLineItemName)+"')]");
        driver.findElement(xpathContainsString).click();

        wait.until(ExpectedConditions.elementToBeClickable(FirstLineItemGearIcon));
    }

    public void clickProcessOrder()
    {
        driver.findElement(ProcessOrderButton).click();
    }

    //Credit Cards
    public void typeCardNumber(String _cardNumber)
    {
        driver.findElement(CardNumber).sendKeys(_cardNumber);
    }
    public void selectCardExpirationMonth(String _cardExpMonth)
    {
        WebElement element = driver.findElement(CardExpirationMonth);
        Select cardExpirationMonth = new Select(element);
        cardExpirationMonth.selectByVisibleText(_cardExpMonth);
    }
    public void selectCardExpirationYear(String _CardExpDay)
    {
        WebElement element = driver.findElement(CardExpirationYear);
        Select cardExpirationYear = new Select(element);
        cardExpirationYear.selectByVisibleText(_CardExpDay);
    }
    public void typeCCVcode(String _ccvCode)
    {
        driver.findElement(CCVCode).sendKeys(_ccvCode);
    }

    //eChecks
    public void typeBankAccountNumber(String _bankAccountNumber)
    {
        driver.findElement(BankAccountNumber).sendKeys(_bankAccountNumber);
    }
    public void typeRoutingAccountNumber(String _routingAccountNumber)
    {
        driver.findElement(RoutingAccountNumber).sendKeys(_routingAccountNumber);
    }





}
