package pagefactory;

import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

public class PageFactory {

    private static ProductPage productPageFactory;

    private PageFactory(){};

    public static ProductPage getProductPage(WebDriver driver){
        if(productPageFactory == null){
            productPageFactory = new ProductPage(driver);
        }
        return  productPageFactory;
    };
}
