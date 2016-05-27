package Membership;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MembershipCreate {

    WebDriver driver;

    public MembershipCreate(WebDriver driver)
    {
        this.driver = driver;
    }

    By anIndividualWhoAlreadyExistsInTheSystem = By.id("ctl00_body_rbAction_0");
    By anOrganizationThatAlreadyExistsInTheSystem = By.id("ctl00_body_rbAction_1");
    By aNewIndividualThatIsNotInTheSystem = By.id("ctl00_body_rbAction_2");
    By aNewOrganizationThatIsNotInTheSystem = By.id("ctl00_body_rbAction_3");

    By continueButton = By.id("ctl00_body_lb_Continue");
    By cancelButton = By.id("ctl00_body_lb_Cancel");

    public void clickAnIndividualWhoAlreadyExistsInTheSystem()
    {
        driver.findElement(anIndividualWhoAlreadyExistsInTheSystem).click();
    }

    public void clickAnOrganizationThatAlreadyExistsInTheSystem()
    {
        driver.findElement(anOrganizationThatAlreadyExistsInTheSystem).click();
    }

    public void clickNewIndividualThatIsNotInTheSystem()
    {
        driver.findElement(aNewIndividualThatIsNotInTheSystem).click();
    }

    public void clickNewOrganizationThatIsNotInTheSystem()
    {
        driver.findElement(aNewOrganizationThatIsNotInTheSystem).click();
    }


}
