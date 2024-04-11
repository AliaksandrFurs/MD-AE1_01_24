package elements;

import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProducentCheckboxes extends BasicCheckboxs{

    WebDriver driver;
    private static final String PATTERN = "//ul[@class='catalog-form__checkbox-list']//*[text()='%s']" +
            "/ancestor-or-self::label//*[@type='checkbox']";

    public ProducentCheckboxes (WebDriver driver){

        name = ProductPageCheckboxTypeEnum.PRODUCENT.toString();
        this.driver= driver;
    }

    //public void selectProducent(ProducentEnum producent){

        //By xpath = By.xpath(String.format(PATTERN, producent.getValue()));
        //WebElement itemElement = driver.findElement(xpath);
        //itemElement.click();
    //}

    @Override
    public String getCheckboxTypeName() {
        return name;
    }

    @Override
    public void selectCheckbox(ProducentEnum producent) {

        By xpath = By.xpath(String.format(PATTERN, producent.getValue()));
        WebElement itemElement = driver.findElement(xpath);
        itemElement.click();

    }

    @Override
    public BasicCheckboxs getCheckbox() {
        return this;
    }

}
