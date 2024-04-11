package utils;

import org.openqa.selenium.WebDriver;

public class Browser {

    public Browser(){}

    public  void browserSetup(WebDriver driver) {
        driver.manage().window().maximize();
    }

}
