package pages;

import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class MainPage extends BasicPage {

    public static  final String URL = "https://www.onliner.by/";

    public MainPage (WebDriver driver){
        super(driver);
        driver.get(URL);
        this.allBars.put(BarTypeEnum.HEADERBARMAINNAVIGATION, headerBarMainNavigationValue);
        this.allBars.put(BarTypeEnum.HEADERBARPRODUCTNAVIGATION, headerBarProductNavigationValue);
    }


    @Override
    public void openPage(BarTypeEnum enumType, BarValuesEnum pageValue) {

        headerBarMainNavigationValue.getHeaderLogo().click();
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());

    }

    @Override
    public void isOpened() {

        Wait.isElementPresented(headerBarMainNavigationValue.getHeaderLogo());
        Wait.isElementPresented(headerBarMainNavigationValue.getTopElement());
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());

        //return driver.findElements().size() > 0 && driver.findElements(headerBar.getTopElement()).size() > 0;
    }

    @Override
    public void goToMain() {

        headerBarMainNavigationValue.getHeaderLogo().click();
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());
    }
}
