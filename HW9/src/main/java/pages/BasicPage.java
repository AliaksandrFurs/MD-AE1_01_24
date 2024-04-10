package pages;

import elements.HeaderBar;
import elements.ItemBar;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage implements  Page {

    protected HeaderBar headerBar;
    protected ItemBar itemBar;
    protected WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.headerBar = new HeaderBar(driver);
        this.itemBar = new ItemBar(driver);
    }
}
