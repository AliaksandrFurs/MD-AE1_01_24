package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsfactory.WaitFactory;

public class Wait {

    private static final long DEFAULT_WAIT_IN_SEC = 10;

    public static void isElementPresented(WebDriver driver, By element){

        WebDriverWait wait = WaitFactory.getWait(driver, DEFAULT_WAIT_IN_SEC);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public static void isElementClickable(WebDriver driver, By element){

        WebDriverWait wait = WaitFactory.getWait(driver, DEFAULT_WAIT_IN_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    };
}
