package pages;

import org.openqa.selenium.By;

public class ProductPage {

    By navigationBar = By.className("catalog-navigation catalog-navigation_bar catalog-navigation_simple");
    By productTitle = By.className("catalog-form__title catalog-form__title_big-alter");

    private ProductPage(){}

    public static ProductPage getProductPage(){
        return new ProductPage();
    };

    public By getNavigationBar() {
        return navigationBar;
    }

    public By getProductTitle() {
        return productTitle;
    }
}
