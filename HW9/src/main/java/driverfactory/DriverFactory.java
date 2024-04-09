package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "C:/Users/37529/IdeaProjects/MyTestSeleniumProject/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver == null) {
            driver.quit();
            driver = null;
        }
    }
}
