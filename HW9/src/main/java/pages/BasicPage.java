package pages;

import elements.HeaderBar;
import elements.ItemBar;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage implements  Page {

    protected HeaderBar headerBar;
    protected ItemBar itemBar;
    protected WebDriver webDriver;

    public BasicPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.headerBar = new HeaderBar(webDriver);
        this.itemBar = new ItemBar(webDriver);
    }
}
