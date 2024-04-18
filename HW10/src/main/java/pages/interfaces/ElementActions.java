package pages.interfaces;

import enums.product.ProductPageProducentEnum;
import enums.ProductPageCheckboxTypeEnum;

public interface ElementActions {

    void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProductPageProducentEnum producent);
}
