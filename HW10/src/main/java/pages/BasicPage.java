package pages;

import elements.bars.BasicBar;
import elements.bars.MainPageTopBarNavigationBar;
import elements.bars.MainPageProductNavigationBar;
import enums.BarTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public abstract class BasicPage {

    protected MainPageTopBarNavigationBar mainPageTopBarNavigationBar;
    protected MainPageProductNavigationBar mainPageProductNavigationBar;
    protected WebDriver driver;
    protected HashMap<BarTypeEnum, BasicBar> basicBars = new HashMap<>();

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.mainPageTopBarNavigationBar = new MainPageTopBarNavigationBar(driver);
        this.mainPageProductNavigationBar = new MainPageProductNavigationBar(driver);
        basicBars.put(BarTypeEnum.HEADERBARMAINNAVIGATION, mainPageTopBarNavigationBar);
        basicBars.put(BarTypeEnum.HEADERBARPRODUCTNAVIGATION, mainPageProductNavigationBar);
        PageFactory.initElements(driver, this);
    }

     static final By consentElement = By.xpath("//div[@class='fc-consent-root']");

     static final By acceptButton = By.xpath("//p[@class='fc-button-label']");


}
