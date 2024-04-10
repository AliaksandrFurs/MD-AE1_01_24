package elements;

import enums.HeaderEnum;
import enums.ItemBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemBar {

    private static final String PATTERN = "//div//a//span[contains(text(),'%s')]";
    WebDriver driver;

    public ItemBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnItem(ItemBarEnum itembar) {
        By xpath = By.xpath(String.format(PATTERN, itembar.getValue()));
        WebElement itemElement = driver.findElement(xpath);
        itemElement.click();

    }
}
