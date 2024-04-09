package elements;

import enums.HeaderEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderBar {

    private static final String PATTERN = "//nav//*[contains(text(),'%s')]";
    WebDriver driver;

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnItem(HeaderEnum headerenum) {
        By xpath = By.xpath(String.format(PATTERN, headerenum.getValue()));

        //WaitUtil.waitUntilElementVisible(webDriver, xpath, DEFAULT_ELEMENT_WAIT_IN_SECOND);

        WebElement menuElement = driver.findElement(xpath);
        menuElement.click();

    }
}
