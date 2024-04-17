package elements;

import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ItemBarProductNavigation extends  BasicBar{

    private static final String PATTERN = "//div//a//span[contains(text(),'%s')]";
    WebDriver driver;

    public ItemBarProductNavigation(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        name = BarTypeEnum.HEADERBARPRODUCTNAVIGATION.toString();
    }

    @Override
    public String getBarName() {
        return this.name;
    }

    @Override
    public void clickOnBar(BarValuesEnum enumValue) {

        By xpath = By.xpath(String.format(PATTERN, enumValue.getValue()));
        WebElement catalogueElement = driver.findElement(xpath);
        catalogueElement.click();

    }

    @Override
    public BasicBar getBar() {
        return this;
    }

    @Override
    public boolean isElementPresented(BarValuesEnum elementName) {

        return driver.findElements(By.xpath(String.format(PATTERN, elementName.getValue()))).size() > 0;
    }
}
