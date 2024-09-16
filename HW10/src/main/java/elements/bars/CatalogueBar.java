package elements.bars;

import enums.catalogue.CatalogueNavigationBarEnum;
import enums.main.MainPageTopBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatalogueBar extends BasicBar implements elements.interfaces.CatalogueBar {

    private final static String PATTERN = "//div[contains(@class, 'g-middle-i')]//ul[contains(@class, 'navigation-classifier')]" +
            "//span[contains(@class,'item-title')]//span[contains(text(),'%s')]";
    WebDriver driver;

    public CatalogueBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        name = MainPageTopBarEnum.CATALOG.toString();
    }

    @FindBy(className = "catalog-navigation catalog-navigation_opened")
    private WebElement catalogueBar;

    @Override
    public String getBarName() {
        return this.name;
    }

    @Override
    public BasicBar getBar() {
        return this;
    }

    @Override
    public  void clickOnBar(CatalogueNavigationBarEnum enumType) {
        try{
            By xpath = By.xpath(String.format(PATTERN, enumType.getValue()));
            WebElement catalogueElement = driver.findElement(xpath);
            catalogueElement.click();

        } catch (NoSuchElementException e) {
            System.out.println("No element found");

        }
    }

    @Override
    public  boolean isElementPresented(CatalogueNavigationBarEnum enumType) {

            return driver.findElements(By.xpath(String.format(PATTERN, enumType.getValue()))).size() > 0;

    }
}
