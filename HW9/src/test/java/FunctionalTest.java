import elements.HeaderBar;
import enums.ItemBarEnum;
import enums.ProducentEnum;
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
        Wait.isElementPresented(driver, HeaderBar.getTOPELEMENT(), 10);

    }

    @BeforeMethod
    public void basicVerificationAndNavigateTo(){

        productPage.openPage(ItemBarEnum.TV);
        productPage.isOpened();
    }

    @AfterMethod
    public void goToMain(){

        driver.findElement(HeaderBar.getHEADERLOGO()).click();
        Wait.isElementClickable(driver, HeaderBar.getHEADERLOGO(), 10);

    }

    @Test(description = "Selecting checkboxses")
    public void selectSamsungTest(){

        productPage.selectCheckbox(ProducentEnum.SAMSUNG);
        Wait.isElementPresented(driver, ProductPage.getRESULTFILTER(), 10);

        String resultText = driver.findElement(ProductPage.getRESULTELEMENT()).getText();

        Assert.assertTrue(resultText.contains(ProducentEnum.SAMSUNG.toString()), "No Samsung TV on the list");
    }

}
