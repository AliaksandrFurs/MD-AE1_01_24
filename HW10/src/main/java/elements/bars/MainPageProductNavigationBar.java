package elements.bars;

import elements.interfaces.MainBar;
import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPageProductNavigationBar extends BasicBar implements MainBar {

    private static final String PATTERN = "//div//a//span[contains(text(),'%s')]";
    WebDriver driver;

    public MainPageProductNavigationBar(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        name = BarTypeEnum.HEADERBARPRODUCTNAVIGATION.toString();
    }

    @Override
    public String getBarName() {
        return this.name;
    }

    @Override
    public void clickOnBar(MainPageTopBarEnum enumValue) {
        try {
            By xpath = By.xpath(String.format(PATTERN, enumValue.getValue()));
            WebElement catalogueElement = driver.findElement(xpath);
            catalogueElement.click();
        }catch(NoSuchElementException e){
            System.out.println("No element found");
        }

    }

    @Override
    public boolean isElementPresented(MainPageTopBarEnum elementName) {

        return driver.findElements(By.xpath(String.format(PATTERN, elementName.getValue()))).size() > 0;
    }

    @Override
    public BasicBar getBar() {
        return this;
    }

}
