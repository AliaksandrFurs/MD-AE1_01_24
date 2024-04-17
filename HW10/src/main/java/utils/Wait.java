package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static final long DEFAULT_WAIT_IN_SEC = 20;
    private static WebDriver driver = Browser.getDriver();
    private static final WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_IN_SEC);

    public static void isElementPresented(WebElement element){

        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void isElementClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}
