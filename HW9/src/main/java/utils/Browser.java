package utils;

import driverfactory.DriverFactory;
import enums.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.browserconfiguration.ChromeConfiguration;

public class Browser {

    private static WebDriver driver;


    public Browser(BrowsersEnum browserName){

        switch (browserName){

            case CHROME:
                driver = DriverFactory.getChromeDriver(new ChromeOptions());
                break;
        }

    }

    public  void browserSetup() {
        driver.manage().window().maximize();
    }

    public void browserClose(){

        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
