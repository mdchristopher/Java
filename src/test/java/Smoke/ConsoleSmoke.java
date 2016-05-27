package Smoke;

import CRM.*;
import Console.ConsoleHome;
import Console.Header;
import Console.LoginPage;
import Financial.PaymentCreate;
import Orders.Order360;
import Orders.OrderCreate;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

public class ConsoleSmoke {

    WebDriver driver;

    @BeforeTest
    public void loadBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://console.financial.membersuite.com/app/console/login?redirectUrl=/app/console/home");
    }

    @AfterTest
    public void unloadBrowser()
    {
        Header header = new Header(driver);
        header.clickSignOut();

        Assert.assertTrue(driver.getTitle().contains("MemberSuite - Login to MemberSuite"));

        driver.close();
    }

    public void navigateToIndSamplePortalUser() //move this to a Common class
    {
        driver.get("https://console.financial.membersuite.com/app/console/individual/view?c=29ef8232-0006-cda9-3711-0b3b1e1da68a");
    }

    public void navigateToOrgMemberSuite() //move this to a Common class
    {
        driver.get("https://console.financial.membersuite.com/app/console/organization/view?c=29ef8232-0007-c4f2-c5e4-0b3b1816723c&updateQuickSearch=False");
    }

    @Test
    public void loginToConsole()
    {
        LoginPage login = new LoginPage(driver);

        login.typeUserName("MattAutoTest");
        login.typePassword("MattAutoTest");
        login.clickLoginButton();

        //Assert.assertTrue("Title should contain MemberSuite - QA Test Automation ConsoleHome", driver.getTitle().contains("MemberSuite - QA Test Automation ConsoleHome"));
        Assert.assertTrue(driver.getTitle().contains("MemberSuite - QA Test Automation Home"));

    }

    @Test
    public void createAnIndividual() //redo the assert like createOpenOrderForIndividual
    {
        loginToConsole();

        ConsoleHome consoleHome = new ConsoleHome(driver);
        consoleHome.clickCRMmodule();

        CRM_Home crmHome = new CRM_Home(driver);
        crmHome.clickCreateAnIndividual();

        CRM_IndividualEdit individualEdit = new CRM_IndividualEdit(driver);
        individualEdit.enterBasicInfo("Matthew", "Christopher", "mchristopher+auto@membersuite.com", "678-327-6801");
        individualEdit.clickSave();

        Assert.assertTrue(driver.getTitle().contains("MemberSuite - Individual 360°"));
    }

    @Test
    public void editAndSaveIndividual() //redo the assert like createOpenOrderForIndividual
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        loginToConsole();
        navigateToIndSamplePortalUser();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickEditThisIndividual();

        CRM_IndividualEdit individualEdit = new CRM_IndividualEdit(driver);
        individualEdit.typeMainPhoneNumber("123-456-789");
        individualEdit.clickSave();

        Assert.assertTrue(driver.getPageSource().contains("The operation was completed successfully."));

    }

    @Test
    public void createAnOrganization() //redo the assert like createOpenOrderForIndividual
    {
        loginToConsole();

        ConsoleHome consoleHome = new ConsoleHome(driver);
        consoleHome.clickCRMmodule();

        CRM_Home crmHome = new CRM_Home(driver);
        crmHome.clickCreateAnOrganization();

        CRM_OrganizationEdit organizationEdit = new CRM_OrganizationEdit(driver);
        organizationEdit.enterBasicInfo("MemberSuite", "mchristopher+auto@membersuite.com", "678-327-6801");
        organizationEdit.inputDefaultCreditTerms("Net60");
        organizationEdit.clickSave();

        Assert.assertTrue(driver.getTitle().contains("MemberSuite - Organization 360°"));
    }

    @Test
    public void editAndSaveOrganization() //redo the assert like createOpenOrderForIndividual
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        loginToConsole();
        navigateToOrgMemberSuite();

        CRM_Organization360 organization360 = new CRM_Organization360(driver);
        organization360.clickEditThisOrganization();

        CRM_OrganizationEdit organizationEdit = new CRM_OrganizationEdit(driver);
        organizationEdit.typeMainPhoneNumber("123-456-7890");
        organizationEdit.clickSave();

        Assert.assertTrue(driver.getPageSource().contains("The operation was completed successfully."));

    }

    @Test
    public void receiveCreditCardPaymentToIndividual()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickReceivePayment();

        PaymentCreate receivePayment = new PaymentCreate(driver);
        receivePayment.selectPaymentMethod("Credit Card");
        receivePayment.typeAmount("100.00");
        receivePayment.typeCreditCardNumber("4111111111111111");
        receivePayment.selectCardExpirationMonth("November");
        receivePayment.selectCardExpirationYear("2020");
        receivePayment.typeCCVcode("777");
        receivePayment.clickPPSprocessPaymentBtn();

        receivePayment.isPaymentSuccessful();

        //remove this if the above method works
        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_divMessage")));
        //Assert.assertTrue(driver.getPageSource().contains("The payment was processed successfully."));
    }

    @Test
    public void receiveECheckPaymentToIndividual()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickReceivePayment();

        PaymentCreate receivePayment = new PaymentCreate(driver);
        receivePayment.selectPaymentMethod("Electronic Check");
        receivePayment.typeAmount("100");
        receivePayment.typeBankAccountNumber("123456789");
        receivePayment.typeRoutingAccountNumber("061000052");
        receivePayment.clickPPSprocessPaymentBtn();

        receivePayment.isPaymentSuccessful();
    }

    @Test
    public void receiveOtherPaymentToIndividual()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickReceivePayment();

        PaymentCreate receivePayment = new PaymentCreate(driver);
        receivePayment.selectPaymentMethod("Other");
        receivePayment.typeAmount("100");
        receivePayment.clickProcessPaymentBtn();

        receivePayment.isPaymentSuccessful();
    }

    @Test
    public void createOpenOrderForIndividual()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();
        //createAnIndividual();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickCreateAnOrder();

        OrderCreate orderCreate = new OrderCreate(driver);
        orderCreate.addFirstLineItem("Penny");
        orderCreate.clickProcessOrder();

        Order360 order360 = new Order360(driver);
        order360.isOrderSuccessful();
    }

    @Test
    public void createOrderForIndividualWithCreditCardPayment()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();
        //createAnIndividual();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickCreateAnOrder();

        OrderCreate orderCreate = new OrderCreate(driver);
        orderCreate.addFirstLineItem("Penny");
        orderCreate.selectPaymentMethod("Credit Card");
        orderCreate.typeCardNumber("4111111111111111");
        orderCreate.selectCardExpirationMonth("November");
        orderCreate.selectCardExpirationYear("2020");
        orderCreate.typeCCVcode("777");
        orderCreate.clickProcessOrder();

        Order360 order360 = new Order360(driver);
        order360.isOrderSuccessful();
    }

    @Test
    public void createOrderForIndividualWithECheckPayment()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();
        //createAnIndividual();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickCreateAnOrder();

        OrderCreate orderCreate = new OrderCreate(driver);
        orderCreate.addFirstLineItem("Penny");
        orderCreate.selectPaymentMethod("Electronic Check");
        orderCreate.typeBankAccountNumber("123456789");
        orderCreate.typeRoutingAccountNumber("061000052");
        orderCreate.clickProcessOrder();

        Order360 order360 = new Order360(driver);
        order360.isOrderSuccessful();

    }

    @Test
    public void createOrderForIndividualWithCashPayment()
    {
        loginToConsole();
        navigateToIndSamplePortalUser();
        //createAnIndividual();

        CRM_Individual360 individual360 = new CRM_Individual360(driver);
        individual360.clickCreateAnOrder();

        OrderCreate orderCreate = new OrderCreate(driver);
        orderCreate.addFirstLineItem("Penny");
        orderCreate.selectPaymentMethod("Cash");
        orderCreate.clickProcessOrder();

        Order360 order360 = new Order360(driver);
        order360.isOrderSuccessful();

    }

    //ToDo
    public void createMembershipForAnIndividualThatAlreadExistsInTheSystem()
    {

    }

    public void createMembershipForAnOrganizationThatAlreadyExistsInTheSystem()
    {

    }

    public void createMembershipForNewIndividual()
    {

    }

    public void createMembershipForNewOrganization()
    {

    }

}
