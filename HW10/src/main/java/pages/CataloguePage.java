package pages;

import elements.bars.CatalogueBar;
import enums.BarTypeEnum;
import enums.catalogue.CatalogueNavigationBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.interfaces.CatalogPageActions;
import utils.Wait;
import java.util.ArrayList;
import java.util.List;

public class CataloguePage extends BasicPage implements CatalogPageActions {

    protected CatalogueBar catalogueBar = new CatalogueBar(driver);
    protected elements.bars.CatalogueNavigationBar catalogueNavigationBar = new elements.bars.CatalogueNavigationBar(driver);
    protected List<WebElement> itemPrice = new ArrayList<>();
    protected List<WebElement> itemQuantity = new ArrayList<>();
    protected List<WebElement> itemName = new ArrayList<>();

    private By itemPriceLocator = By.xpath("//span[@class='catalog-navigation-list__dropdown-description']/span");
    private By itemNameLocator = By.className("catalog-navigation-list__dropdown-title");
    private By itemQuantityLocator = By.className("catalog-navigation-list__dropdown-description");

    public CataloguePage (WebDriver driver){

        super(driver);

    }

    @Override
    public void openPage(BarTypeEnum enumType, CatalogueNavigationBarEnum pageName) {

        try {
            switch(enumType){
                case CATALOGUEMAIN:
                    catalogueBar.clickOnBar(pageName);
                    break;
                case CATALOGUENAVIGATION:
                    catalogueNavigationBar.clickOnBar(pageName);
            }
        }catch(NoSuchElementException e){
            System.out.println("No such element");
        }
        checkElementsLists();
        countAndAddItems();

    }


    @Override
    public void isOpened() {

        Wait.isElementPresented(mainPageTopBarNavigationBar.getHeaderLogo());
        Wait.isElementPresented(mainPageTopBarNavigationBar.getTopElement());
        Wait.isElementClickable(mainPageTopBarNavigationBar.getHeaderLogo());
    }

    @Override
    public void goToMain() {

        mainPageTopBarNavigationBar.getHeaderLogo().click();
        Wait.isElementClickable(mainPageTopBarNavigationBar.getHeaderLogo());
    }

    @Override
    public void skipConsents() {

        if(driver.findElements(consentElement).size() == 1){
            driver.findElement(acceptButton).click();
        }
    }

    private void countAndAddItems(){

        itemPrice = driver.findElements(itemPriceLocator);
        itemName = driver.findElements(itemNameLocator);
        itemQuantity = driver.findElements(itemQuantityLocator);
    }

    private void checkElementsLists(){
        if(itemPrice.size() > 0){
            itemPrice.clear();
        }
        if(itemQuantity.size() > 0){
            itemQuantity.clear();
        }
        if(itemName.size() > 0){
            itemName.clear();
        }
    }


    public CatalogueBar getCatalogueBar() {
        return catalogueBar;
    }

    public elements.bars.CatalogueNavigationBar getCatalogueNavigationBar() {
        return catalogueNavigationBar;
    }

    public List<WebElement> getItemPrice() {
        return itemPrice;
    }

    public List<WebElement> getItemQuantity() {
        return itemQuantity;
    }

    public List<WebElement> getItemName() {
        return itemName;
    }
}
