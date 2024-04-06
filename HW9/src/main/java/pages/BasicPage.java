package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicPage {
    WebDriver driver;

    By mainLogo = By.className("onliner_logo");

    public By getMainLogo() {
        return mainLogo;
    }
}
