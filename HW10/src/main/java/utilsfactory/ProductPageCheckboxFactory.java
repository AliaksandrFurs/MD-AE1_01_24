package utilsfactory;

import elements.BasicBar;
import elements.BasicCheckboxs;
import elements.ProducentCheckboxes;
import enums.BarTypeEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ProductPageCheckboxFactory {

    private static HashMap <ProductPageCheckboxTypeEnum, BasicCheckboxs> checkboxesFactory;
    //private static HashMap<BarTypeEnum, BasicBar> barsFactory;

    private ProductPageCheckboxFactory(){}

    public static HashMap getAllPageCheckboxes(WebDriver driver){

        if(checkboxesFactory == null){

            checkboxesFactory = new HashMap<>();
            checkboxesFactory.put(ProductPageCheckboxTypeEnum.PRODUCENT, new ProducentCheckboxes(driver));
        }
        return  checkboxesFactory;
    }

}
