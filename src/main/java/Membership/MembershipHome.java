package Membership;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MembershipHome {

    WebDriver driver;

    public MembershipHome(WebDriver driver)
    {
        this.driver = driver;
    }

    By createMember = By.xpath(".//*[@id='ctl00_body_Tasks_Content']/table/tbody/tr[1]/td[1]/a/span[2]/span/span[1]");

    public void clickCreateMember()
    {
        driver.findElement(createMember).click();
    }

}
