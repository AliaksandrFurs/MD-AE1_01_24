package elements;

import enums.product.ProductPageProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @Override
    public String getCheckboxTypeName() {
        return this.name;
    }

    @Override
    public void selectCheckbox(ProductPageProducentEnum producent) {
        try {
            By xpath = By.xpath(String.format(PATTERN, producent.getValue()));
            WebElement itemElement = driver.findElement(xpath);
            itemElement.click();
        }catch(NoSuchElementException e){
            System.out.println("No element found");
        }

    }

    @Override
    public BasicCheckboxs getCheckbox() {
        return this;
    }

}
