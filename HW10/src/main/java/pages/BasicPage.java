package pages;

import elements.BasicBar;
import elements.BasicCheckboxs;
import elements.HeaderBarMainNavigation;
import elements.ItemBarProductNavigation;
import enums.BarTypeEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public abstract class BasicPage implements BasicActions {

    protected HeaderBarMainNavigation headerBarMainNavigationValue;
    protected ItemBarProductNavigation headerBarProductNavigationValue;
    protected WebDriver driver;
    protected HashMap<ProductPageCheckboxTypeEnum, BasicCheckboxs> allCheckboxes;
    protected HashMap<BarTypeEnum, BasicBar> allBars;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.headerBarMainNavigationValue = new HeaderBarMainNavigation(driver);
        this.headerBarProductNavigationValue = new ItemBarProductNavigation(driver);
    }


}
