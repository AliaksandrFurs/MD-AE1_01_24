import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import pagefactory.PageFactory;
import pages.MainPage;
import pages.ProductPage;

public class FunctionalTest extends BaseTest{

    MainPage mainPage = PageFactory.getMainPage();
    ProductPage productPage = PageFactory.getProductPage();

    @BeforeMethod
    public void basicVerificationAndNavigateTo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.getNavigationBar()));
        driver.findElement(mainPage.getTvSection()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.getNavigationBar()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.getProductTitle()));
    }


}
