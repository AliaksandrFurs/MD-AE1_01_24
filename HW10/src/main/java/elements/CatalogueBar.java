package elements;

import enums.BarValuesEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class CatalogueBar extends BasicBar{

    private final static String PATTERN = "//div[contains(@class, 'g-middle-i')]//ul[contains(@class, 'navigation-classifier')]" +
            "//span[contains(@class,'item-title')]//span[contains(text(),'%s')]";
    WebDriver driver;

    public CatalogueBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        name = BarValuesEnum.CATALOG.toString();
    }

    @FindBy(className = "catalog-navigation catalog-navigation_opened")
    private WebElement catalogueBar;

    @Override
    public String getBarName() {
        return this.name;
    }

    @Override
    public void clickOnBar(BarValuesEnum enumValue) {

        By xpath = By.xpath(String.format(PATTERN, enumValue.getValue()));
        WebElement catalogueElement = driver.findElement(xpath);
        catalogueElement.click();
        Wait.isElementPresented(catalogueElement);
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
