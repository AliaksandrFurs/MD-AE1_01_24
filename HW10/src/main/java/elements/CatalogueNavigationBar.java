package elements;

import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogueNavigationBar extends BasicBar{

    WebDriver driver;
    private static final String PATTERN = "//ul[contains(@class, 'catalog-navigation-classifier')]" +
            "//li[contains(@class, 'catalog-navigation-classifier__item')]//span[contains(text(),'%s')]" +
            "/ancestor-or-self::li[@class='catalog-navigation-classifier__item']";

    public CatalogueNavigationBar(WebDriver driver){
        this.driver = driver;
        this.name = BarTypeEnum.CATALOGUENAVIGATION.toString();
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
