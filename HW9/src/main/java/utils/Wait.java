package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static final long DEFAULT_WAIT_IN_SEC = 10;
    private static WebDriver driver = Browser.getDriver();
    private static final WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_IN_SEC);

    public static void isElementPresented(By element){

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public static void isElementClickable(By element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    };
}
