import elements.HeaderBar;
import enums.ItemBarEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.testng.Assert;
import org.testng.annotations.*;
import pagefactory.PageFactory;
import pages.ProductPage;
import utils.Wait;

public class FunctionalTest extends BaseTest{

    ProductPage productPage = PageFactory.getProductPage(driver);

    @BeforeClass
    public void basicVerification(){

        driver.get(URL);
        Wait.isElementPresented(HeaderBar.getTOPELEMENT());

    }

    @BeforeMethod
    public void basicVerificationAndNavigateTo(){

        productPage.openPage(ItemBarEnum.TV);
        productPage.isOpened();
    }

    @AfterMethod
    public void goToMain(){

        driver.findElement(HeaderBar.getHEADERLOGO()).click();
        Wait.isElementClickable(HeaderBar.getHEADERLOGO());

    }

    @Test(description = "Selecting checkboxses")
    public void selectSamsungTest(){

        productPage.selectCheckbox(ProductPageCheckboxTypeEnum.PRODUCENT, ProducentEnum.LG);
        Wait.isElementPresented(ProductPage.getRESULTFILTER());

        String resultText = driver.findElement(ProductPage.getRESULTELEMENT()).getText();

        Assert.assertTrue(resultText.contains(ProducentEnum.LG.toString()), "No LG TV on the list");
    }

}
