package pagefactory;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.ProductPage;

public class PageFactory {

    private static ProductPage productPageFactory;
    private static MainPage mainPageFactory;

    private PageFactory(){};

    public static ProductPage getProductPage(WebDriver driver){
        if(productPageFactory == null){
            productPageFactory = new ProductPage(driver);
        }
        return  productPageFactory;
    };

    public static MainPage getMainPage(WebDriver driver){
        if(mainPageFactory == null){
            mainPageFactory = new MainPage(driver);
        }
        return  mainPageFactory;
    };
}
