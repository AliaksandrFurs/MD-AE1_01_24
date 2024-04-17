
import enums.BarTypeEnum;
import enums.BarValuesEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.PageFactory;
import pages.MainPage;
import pages.ProductPage;

public class FunctionalTest extends BaseTest{

    ProductPage productPage = PageFactory.getProductPage(driver);
    MainPage mainPage = PageFactory.getMainPage(driver);

    //@BeforeClass
    //public void basicVerification(){

        //mainPage.isOpened();

    //}

    @BeforeMethod
    public void navigateTo(){

        productPage.openPage(BarTypeEnum.HEADERBARPRODUCTNAVIGATION,BarValuesEnum.TV);

    }

    @AfterMethod
    public void goToMain(){

        productPage.goToMain();

    }

    @Test(description = "Selecting checkboxses")
    public void selectSamsungTest(){

        productPage.selectCheckbox(ProductPageCheckboxTypeEnum.PRODUCENT, ProducentEnum.LG);

        String resultText = productPage.getResultElement().getText();

        Assert.assertTrue(resultText.contains(ProducentEnum.LG.toString()), "No LG TV on the list");
    }

}
