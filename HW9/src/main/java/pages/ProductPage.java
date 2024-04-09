package pages;

import enums.ItemBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasicPage {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    By formHeader = By.className("h1[@class = 'catalog-form__title catalog-form__title_big-alter']");

    @Override
    public void openPage(ItemBarEnum itembar) {
        itemBar.clickOnItem(itembar);
    }

    public By getFormHeader() {
        return formHeader;
    }
}
