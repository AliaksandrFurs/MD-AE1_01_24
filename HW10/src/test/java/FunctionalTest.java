
import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;
import enums.product.ProductPageProducentEnum;
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

        productPage.openPage(BarTypeEnum.HEADERBARPRODUCTNAVIGATION, MainPageTopBarEnum.TV);

    }

    @AfterMethod
    public void goToMain(){

        productPage.goToMain();

    }

    @Test(description = "Selecting checkboxses")
    public void selectSamsungTest(){

        productPage.selectCheckbox(ProductPageCheckboxTypeEnum.PRODUCENT, ProductPageProducentEnum.LG);

        String resultText = productPage.getResultElement().getText();

        Assert.assertTrue(resultText.contains(ProductPageProducentEnum.LG.toString()), "No LG TV on the list");
    }

}
