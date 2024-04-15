package elements;

import enums.HeaderEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HeaderBar {

    private static final String PATTERN = "//nav//*[contains(text(),'%s')]";
    //private static final By TOPELEMENT = By.className("g-top");
    @FindBy(className = "g-top")
    private  WebElement topElement;
    //private static  final By HEADERLOGO = By.className("onliner-logo");
    @FindBy(className = "onliner-logo")
    private WebElement headerLogo;
    WebDriver driver;


    public HeaderBar(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnItem(HeaderEnum headerenum) {
        By xpath = By.xpath(String.format(PATTERN, headerenum.getValue()));
        WebElement menuElement = driver.findElement(xpath);
        menuElement.click();

    }

    public  WebElement getTopElement() {
        return topElement;
    }

    public WebElement getHeaderLogo() {
        return headerLogo;
    }
}
