import enums.BarTypeEnum;
import enums.BarValuesEnum;
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

    //@BeforeClass
    //public void basicVerification(){

        //mainPage.isOpened();

    //}

    @BeforeMethod
    public void navigateTo(){

        cataloguePage.openPage(BarTypeEnum.HEADERBARMAINNAVIGATION, BarValuesEnum.CATALOG);

    }

    @AfterMethod
    public void goToMain(){

        cataloguePage.goToMain();

    }

    @Test(description = "Validation is catalogue navigation bar is ok")
    public void catalogueBarTest(){

        softAssert.assertTrue(cataloguePage.getCatalogueBar().isElementPresented(BarValuesEnum.ELECTONIC), "No " +
                " electronic section displayed");
        softAssert.assertAll();

    }

    @Test()
    public void catalogueNavigationBarTest(){

        cataloguePage.openPage(BarTypeEnum.CATALOGUENAVIGATION, BarValuesEnum.COMPUTERS);
        Assert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(BarValuesEnum.LAPTOPS),
                "No laptops section displayed ");
        Assert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(BarValuesEnum.PARTS),
                "No parts section displayed");
        Assert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(BarValuesEnum.DATA),
                "No data section displayed");
        Assert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(BarValuesEnum.NETWORK),
                "Nonetwork section displayed");
        softAssert.assertTrue(cataloguePage.getCatalogueNavigationBar().isElementPresented(BarValuesEnum.GAMES),
                " No games section displayed");
        softAssert.assertAll();
    }
}
