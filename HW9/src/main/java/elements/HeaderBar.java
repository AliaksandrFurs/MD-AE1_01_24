package elements;

import enums.HeaderEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderBar {

    private static final String PATTERN = "//nav//*[contains(text(),'%s')]";
    private static final By TOPELEMENT = By.className("g-top");
    private static  final By HEADERLOGO = By.className("onliner-logo");
    WebDriver driver;

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnItem(HeaderEnum headerenum) {
        By xpath = By.xpath(String.format(PATTERN, headerenum.getValue()));
        WebElement menuElement = driver.findElement(xpath);
        menuElement.click();

    }

    public static By getTOPELEMENT() {
        return TOPELEMENT;
    }

    public static By getHEADERLOGO() {
        return HEADERLOGO;
    }
}
