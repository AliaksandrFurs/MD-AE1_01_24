package pages;

import elements.CatalogueBar;
import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.WebDriver;
import pagefactory.PageFactory;
import utils.Wait;

public class CataloguePage extends BasicPage implements BasicActions{

    protected CatalogueBar catalogueBar = new CatalogueBar(driver);

    public CataloguePage (WebDriver driver){

        super(driver);
        this.allBars.put(BarTypeEnum.CATALOGUENAVIGATION, catalogueBar);
        this.allBars.put(BarTypeEnum.CATALOGUEMAIN, catalogueBar);
    }


    @Override
    public void openPage(BarTypeEnum enumType, BarValuesEnum pageType) {

        catalogueBar.clickOnBar(enumType, pageType);
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
}
