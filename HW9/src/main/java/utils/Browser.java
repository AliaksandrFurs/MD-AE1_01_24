package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public Browser(){

    }

    public  void browserSetup(WebDriver driver) {
        //driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_IN_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


}
