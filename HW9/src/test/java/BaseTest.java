import BrowserFactory.BrowserFactory;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.Browser;


public class BaseTest {

    public static  final String URL = "https://www.onliner.by/";
    static Browser browser = BrowserFactory.getBrowser();
    static WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeClass
    public void basicSetup(){
        browser.browserSetup(driver);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    static void close (){
        driver.close();
    }
}
