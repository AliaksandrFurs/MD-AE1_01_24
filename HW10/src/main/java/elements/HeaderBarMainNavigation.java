package elements;

import enums.BarTypeEnum;
import enums.BarValuesEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBarMainNavigation extends BasicBar{

    private static final String PATTERN = "//nav//*[contains(text(),'%s')]";
    //private static final By TOPELEMENT = By.className("g-top");
    @FindBy(className = "g-top")
    private  WebElement topElement;
    //private static  final By HEADERLOGO = By.className("onliner-logo");
    @FindBy(className = "onliner-logo")
    private WebElement headerLogo;
    WebDriver driver;


    public HeaderBarMainNavigation(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        name = BarTypeEnum.HEADERBARMAINNAVIGATION.toString();
    }

    public  WebElement getTopElement() {
        return topElement;
    }

    public WebElement getHeaderLogo() {
        return headerLogo;
    }

    @Override
    public String getBarName() {
        return this.name;
    }

    @Override
    public void clickOnBar(BarTypeEnum enumType, BarValuesEnum enumValue) {

        By xpath = By.xpath(String.format(PATTERN, enumValue.getValue()));
        WebElement menuElement = driver.findElement(xpath);
        menuElement.click();
    }

    @Override
    public BasicBar getBar() {
        return this;
    }
}
