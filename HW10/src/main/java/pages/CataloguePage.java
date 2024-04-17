package pages;

import elements.CatalogueBar;
import elements.CatalogueNavigationBar;
import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class CataloguePage extends BasicPage implements BasicActions{

    protected CatalogueBar catalogueBar = new CatalogueBar(driver);
    protected CatalogueNavigationBar catalogueNavigationBar = new CatalogueNavigationBar(driver);

    public CataloguePage (WebDriver driver){

        super(driver);
        allBars.put(BarTypeEnum.CATALOGUENAVIGATION, catalogueNavigationBar);
        allBars.put(BarTypeEnum.CATALOGUEMAIN, catalogueBar);
    }


    @Override
    public void openPage(BarTypeEnum enumtype, BarValuesEnum pageType) {
        allBars.get(enumtype).clickOnBar(pageType);
        if(consentElement.isDisplayed()){
            acceptButton.click();
        }
        //headerBarMainNavigationValue.clickOnBar(pageType);
    }

    @Override
    public void isOpened() {

        Wait.isElementPresented(headerBarMainNavigationValue.getHeaderLogo());
        Wait.isElementPresented(headerBarMainNavigationValue.getTopElement());
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());
    }

    @Override
    public void goToMain() {

        headerBarMainNavigationValue.getHeaderLogo().click();
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());
    }

    public CatalogueBar getCatalogueBar() {
        return catalogueBar;
    }

    public CatalogueNavigationBar getCatalogueNavigationBar() {
        return catalogueNavigationBar;
    }
}
