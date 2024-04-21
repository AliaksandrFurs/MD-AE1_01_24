import dataproviders.CatalogueTestDataProvider;
import enums.BarTypeEnum;
import enums.catalogue.CatalogueNavigationBarEnum;
import enums.main.MainPageTopBarEnum;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagefactory.PageFactory;
import pages.CataloguePage;
import pages.MainPage;

public class CatalogueTest extends  BaseTest{

    MainPage mainPage = PageFactory.getMainPage(driver);
    CataloguePage cataloguePage = PageFactory.getCataloguePage(driver);
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void basicVerification(){

        //mainPage.isOpened();

    }

    @BeforeMethod
    public void navigateTo(){

        mainPage.openPage(BarTypeEnum.HEADERBARMAINNAVIGATION, MainPageTopBarEnum.CATALOG);
        cataloguePage.isOpened();
        cataloguePage.skipConsents();

    }

    @AfterMethod
    public void goToMain(){

        cataloguePage.goToMain();

    }

    @Test(description = "Validation is catalogue navigation bar is ok", dataProviderClass = CatalogueTestDataProvider.class,
    dataProvider = "cataloguebartest")
    public void catalogueBarTest(CatalogueNavigationBarEnum enumValue){

        softAssert.assertTrue(cataloguePage.getCatalogueBar().isElementPresented(enumValue), "No " +
                enumValue + " section displayed");

        softAssert.assertAll();

    }

    @Test(description = "Validation is catalogue element navigation bar is ok", dataProviderClass = CatalogueTestDataProvider.class,
    dataProvider = "cataloguenavigationbartest")
    public void catalogueNavigationBarTest(CatalogueNavigationBarEnum enumValue){

        cataloguePage.openPage(BarTypeEnum.CATALOGUEMAIN, CatalogueNavigationBarEnum.COMPUTERS);
        Assert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(enumValue),
                "No " + enumValue+ " section displayed ");
        softAssert.assertAll();
    }

    @Test(description = "Validation is items are ok")
    public void itemsBasicTest(){

        cataloguePage.openPage(BarTypeEnum.CATALOGUEMAIN, CatalogueNavigationBarEnum.COMPUTERS);
        cataloguePage.openPage(BarTypeEnum.CATALOGUENAVIGATION, CatalogueNavigationBarEnum.PARTS);
        for(WebElement element: cataloguePage.getItemName()){

            softAssert.assertTrue(element.getText().length() > 0, "No name available");
            softAssert.assertAll();
        }
        for(WebElement element : cataloguePage.getItemPrice()){

            softAssert.assertTrue(element.getText().length() > 0, "No price available");
            softAssert.assertAll();
        }
        for(WebElement element : cataloguePage.getItemQuantity()){

            softAssert.assertTrue(element.getText().length() > 0, "No quantity available");
            softAssert.assertAll();
        }

    }
}
