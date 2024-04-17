package pages;

import elements.BasicBar;
import elements.BasicCheckboxs;
import elements.HeaderBarMainNavigation;
import elements.ItemBarProductNavigation;
import enums.BarTypeEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public abstract class BasicPage implements BasicActions {

    protected HeaderBarMainNavigation headerBarMainNavigationValue;
    protected ItemBarProductNavigation headerBarProductNavigationValue;
    protected WebDriver driver;
    protected HashMap<ProductPageCheckboxTypeEnum, BasicCheckboxs> allCheckboxes = new HashMap<>();
    protected HashMap<BarTypeEnum, BasicBar> allBars = new HashMap<>();

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.headerBarMainNavigationValue = new HeaderBarMainNavigation(driver);
        this.headerBarProductNavigationValue = new ItemBarProductNavigation(driver);
        allBars.put(BarTypeEnum.HEADERBARMAINNAVIGATION, headerBarMainNavigationValue);
        allBars.put(BarTypeEnum.HEADERBARPRODUCTNAVIGATION, headerBarProductNavigationValue);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='fc-consent-root']")
    WebElement consentElement;

    @FindBy(xpath = "//p[@class='fc-button-label']")
    WebElement acceptButton;


}
