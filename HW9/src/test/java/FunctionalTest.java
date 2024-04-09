import enums.ItemBarEnum;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import pagefactory.PageFactory;
import pages.ProductPage;

public class FunctionalTest extends BaseTest{

    ProductPage productPage = PageFactory.getProductPage(driver);

    @BeforeMethod
    public void basicVerificationAndNavigateTo(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getNavigationBar()));
        productPage.openPage(ItemBarEnum.TV);
        driver.findElement(productPage.getFormHeader()).getText();

    }

    @BeforeMethod
    public void goToProductPage(){} // ереходим на страницу с TV



}
