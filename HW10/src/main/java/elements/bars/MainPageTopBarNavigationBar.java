package elements.bars;

import elements.interfaces.MainBar;
import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageTopBarNavigationBar extends BasicBar implements MainBar {

    private static final String PATTERN = "//nav//*[contains(text(),'%s')]";
    @FindBy(className = "g-top")
    private  WebElement topElement;
    @FindBy(xpath = "//img[contains(@Class, 'onliner_logo')]")
    private WebElement headerLogo;
    WebDriver driver;


    public MainPageTopBarNavigationBar(WebDriver driver) {

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
    public void clickOnBar(MainPageTopBarEnum enumValue) {
        try {
            By xpath = By.xpath(String.format(PATTERN, enumValue.getValue()));
            WebElement menuElement = driver.findElement(xpath);
            menuElement.click();

        }catch(NoSuchElementException e){
            System.out.println("No element found");
        }
    }

    @Override
    public BasicBar getBar() {
        return this;
    }

    @Override
    public boolean isElementPresented(MainPageTopBarEnum elementName) {

        return driver.findElements(By.xpath(String.format(PATTERN, elementName.getValue()))).size() > 0;
    }
}
