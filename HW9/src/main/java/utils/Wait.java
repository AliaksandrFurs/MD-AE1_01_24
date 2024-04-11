package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsfactory.WaitFactory;

public class Wait {

    public static void isElementPresented(WebDriver driver, By element, long timeout){

        WebDriverWait wait = WaitFactory.getWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public static void isElementClickable(WebDriver driver, By element, long timeout){

        WebDriverWait wait = WaitFactory.getWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    };
}
