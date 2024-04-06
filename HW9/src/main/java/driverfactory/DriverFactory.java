package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/37529/IdeaProjects/MyTestSeleniumProject/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
