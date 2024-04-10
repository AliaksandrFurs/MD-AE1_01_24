import BrowserFactory.BrowserFactory;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pagefactory.PageFactory;
import pages.BasicPage;
import utils.Browser;


public class BaseTest {

    public static  final String URL = "https://www.onliner.by/";
    static Browser browser = BrowserFactory.getBrowser();
    static WebDriver driver = DriverFactory.getChromeDriver();
    static Wait wait = new WebDriverWait(driver, 10);

    @BeforeClass
    public void basicSetup(){
        browser.browserSetup(driver);
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    static void close (){
        driver.close();
    }
}
