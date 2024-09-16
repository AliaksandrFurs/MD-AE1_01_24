package pages;

import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.interfaces.MainPageActions;
import utils.Wait;

public class MainPage extends BasicPage implements MainPageActions {

    public static  final String URL = "https://www.onliner.by/";

    public MainPage (WebDriver driver){

        super(driver);
        driver.get(URL);
    }


    @Override
    public void openPage(BarTypeEnum enumType, MainPageTopBarEnum pageValue) {
        try {

            switch(enumType){
                case HEADERBARMAINNAVIGATION -> mainPageTopBarNavigationBar.clickOnBar(pageValue);
                case HEADERBARPRODUCTNAVIGATION -> mainPageProductNavigationBar.clickOnBar(pageValue);
            }
            Wait.isElementClickable(mainPageTopBarNavigationBar.getHeaderLogo());
        }catch(NoSuchElementException e){
            System.out.println("No such element");
        }

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


}
