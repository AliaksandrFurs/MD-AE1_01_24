package utilsfactory;

import elements.BasicCheckboxs;
import elements.ProducentCheckboxes;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ProductPageCheckboxFactory {

    private static HashMap <ProductPageCheckboxTypeEnum, BasicCheckboxs> checkboxesFactory;

    private ProductPageCheckboxFactory(){}

    public static HashMap getAllPageCheckboxes(WebDriver driver){

        if(checkboxesFactory == null){

            //checkboxesFactory = new ThreadLocal<>();
            checkboxesFactory = new HashMap<>();
            checkboxesFactory.put(ProductPageCheckboxTypeEnum.PRODUCENT, new ProducentCheckboxes(driver));
            //webDriverWait.set(new WebDriverWait(driver, timeout));
        }
        return  checkboxesFactory;
    }
}
