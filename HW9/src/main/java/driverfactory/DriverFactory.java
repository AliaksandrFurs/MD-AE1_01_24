package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\37529\\IdeaProjects\\MD-AE1_01_24\\HW9\\Drivers\\chromedriver.exe");
    }

    private static ThreadLocal<WebDriver> driver;

    private DriverFactory() {
    }

    public static WebDriver getChromeDriver(ChromeOptions options) {
        if (driver == null) {
            driver = new ThreadLocal<>();
            driver.set(new ChromeDriver(options));

        }
        return driver.get();
    }
}
