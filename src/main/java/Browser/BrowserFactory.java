package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory
{
    static WebDriver driver;

    public static WebDriver startBrowser(String _browserName, String _url)
    {
        if (_browserName.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }

        else if (_browserName.equals("chrome"))
        {
            driver = new ChromeDriver();
        }

        else if (_browserName.equals("IE"))
        {
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.get(_url);
        return driver;
    }

}
