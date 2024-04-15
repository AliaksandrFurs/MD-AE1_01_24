package pages;

import enums.ItemBarEnum;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class MainPage extends BasicPage {

    public static  final String URL = "https://www.onliner.by/";

    public MainPage (WebDriver driver){
        super(driver);
        driver.get(URL);
        //PageFactory.initElements(driver,this);
    }


    @Override
    public void openPage(ItemBarEnum itembar) {

        headerBar.getHeaderLogo().click();
        Wait.isElementClickable(headerBar.getHeaderLogo());

    }

    @Override
    public void isOpened() {

        Wait.isElementPresented(headerBar.getHeaderLogo());
        Wait.isElementPresented(headerBar.getTopElement());
        Wait.isElementClickable(headerBar.getHeaderLogo());

        //return driver.findElements().size() > 0 && driver.findElements(headerBar.getTopElement()).size() > 0;
    }

    @Override
    public void goToMain() {

        headerBar.getHeaderLogo().click();
        Wait.isElementClickable(headerBar.getHeaderLogo());
    }
}
