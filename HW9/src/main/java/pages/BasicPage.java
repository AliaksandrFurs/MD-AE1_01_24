package pages;

import elements.BasicCheckboxs;
import elements.HeaderBar;
import elements.ItemBar;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public abstract class BasicPage implements  Page {

    protected HeaderBar headerBar;
    protected ItemBar itemBar;
    protected WebDriver driver;
    protected HashMap<ProductPageCheckboxTypeEnum, BasicCheckboxs> allCheckboxes;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.headerBar = new HeaderBar(driver);
        this.itemBar = new ItemBar(driver);
    }


}
