package elements;

import enums.ProducentEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProducentCheckboxes {

    WebDriver driver;
    private static final String PATTERN = "//ul[@class='catalog-form__checkbox-list']//*[text()='%s']" +
            "/ancestor-or-self::label//*[@type='checkbox']";

    public ProducentCheckboxes (WebDriver driver){
        this.driver= driver;
    }

    public void selectProducent(ProducentEnum producent){

        By xpath = By.xpath(String.format(PATTERN, producent.getValue()));
        WebElement itemElement = driver.findElement(xpath);
        itemElement.click();
    }
}
