

import enums.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.Browser;


public class BaseTest {

    public static  final String URL = "https://www.onliner.by/";
    static Browser browser = new Browser(BrowsersEnum.CHROME);
    static WebDriver driver = Browser.getDriver();

    @BeforeClass
    public void basicSetup(){
        browser.browserSetup();
    }

    @AfterClass(description = "Close browser", alwaysRun = true)
    static void close (){
        browser.browserClose();
    }
}
