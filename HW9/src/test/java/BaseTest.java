import driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pagefactory.PageFactory;
import pages.BasicPage;
import pages.MainPage;

import java.time.Duration;

public class BaseTest {

    public static  final String URL = "https://www.onliner.by/";
    static WebDriver driver = DriverFactory.getChromeDriver();
    static Wait wait = new WebDriverWait(driver, 10);
    private BasicPage basicPage = new BasicPage();

    @BeforeSuite
    public void goToHome(){
        driver.get(URL);
        wait.until(ExpectedConditions.elementToBeClickable(basicPage.getMainLogo()));
    }


    @AfterSuite(description = "Close browser", alwaysRun = true)
    static void close (){
        driver.close();
    }
}
