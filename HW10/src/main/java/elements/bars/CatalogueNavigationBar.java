package elements.bars;

import elements.interfaces.CatalogueBar;
import enums.BarTypeEnum;
import enums.catalogue.CatalogueNavigationBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogueNavigationBar extends BasicBar implements CatalogueBar {

    WebDriver driver;
    private static final String PATTERN = "//div[contains(text(), '%s')]";

    public CatalogueNavigationBar(WebDriver driver){
        this.driver = driver;
        this.name = BarTypeEnum.CATALOGUENAVIGATION.toString();
    }

    @Override
    public  void clickOnBar(CatalogueNavigationBarEnum enumType) {
        try {
            By xpath = By.xpath(String.format(PATTERN, enumType.getValue()));
            WebElement catalogueElement = driver.findElement(xpath);
            catalogueElement.click();

        }catch(NoSuchElementException e){
            System.out.println("No element found");
        }
    }

    @Override
    public boolean isElementPresented(CatalogueNavigationBarEnum elementName) {

        return driver.findElements(By.xpath(String.format(PATTERN, elementName.getValue()))).size() > 0;
    }

    @Override
    public BasicBar getBar() {

        return this;
    }

    @Override
    public String getBarName() {

        return this.name;
    }


}
