package pagefactory;

import com.sun.tools.javac.Main;
import pages.MainPage;
import pages.ProductPage;

public class PageFactory {

    private static MainPage mainPageFactory;
    private static ProductPage productPageFactory;

    private PageFactory(){};

    public static MainPage getMainPage(){
        if(mainPageFactory == null){
            mainPageFactory = MainPage.getMainPage();
        }
        return  mainPageFactory;
    };

    public static ProductPage getProductPage(){
        if(productPageFactory == null){
            productPageFactory = ProductPage.getProductPage();
        }
        return  productPageFactory;
    };
}
