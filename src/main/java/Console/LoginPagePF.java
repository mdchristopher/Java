package Console;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// https://www.youtube.com/watch?v=fUSl-WhqymU&nohtml5=False

public class LoginPagePF
{
    WebDriver driver;

    // I don'd understand this part
    public LoginPagePF(WebDriver ldriver)
    {
        this.driver = ldriver;
    }

    @FindBy(id = "ctl00_body_TextBox1")
    WebElement txtUserName;

    @FindBy(id = "ctl00_body_TextBox2")
    WebElement txtPassword;

    @FindBy(xpath = ".//*[@id='ctl00_body_lb_Login']/span")
    WebElement btnLoginToMemberSuite;

    public void typeUserName(String _username)
    {
        txtUserName.sendKeys(_username);
    }

    public void typePassword(String _password)
    {
        txtPassword.sendKeys(_password);
    }

    public void clickLoginButton()
    {
        btnLoginToMemberSuite.click();
    }
}
