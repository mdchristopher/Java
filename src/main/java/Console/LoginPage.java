package Console;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userName = By.id("ctl00_body_TextBox1");
    By password = By.id("ctl00_body_TextBox2");
    By loginButton = By.xpath(".//*[@id='ctl00_body_lb_Login']/span");


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void typeUserName(String _username)
    {
        driver.findElement(userName).sendKeys(_username);
    }

    public void typePassword(String _password)
    {
        driver.findElement(password).sendKeys(_password);
    }

    public void clickLoginButton()
    {
        driver.findElement(loginButton).click();
    }

}
