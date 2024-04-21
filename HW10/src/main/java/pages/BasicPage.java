package pages;

import elements.bars.MainPageTopBarNavigationBar;
import elements.bars.MainPageProductNavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasicPage {

    protected MainPageTopBarNavigationBar mainPageTopBarNavigationBar;
    protected MainPageProductNavigationBar mainPageProductNavigationBar;
    protected WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.mainPageTopBarNavigationBar = new MainPageTopBarNavigationBar(driver);
        this.mainPageProductNavigationBar = new MainPageProductNavigationBar(driver);
        PageFactory.initElements(driver, this);
    }

     static final By consentElement = By.xpath("//div[@class='fc-consent-root']");

     static final By acceptButton = By.xpath("//p[@class='fc-button-label']");


}
