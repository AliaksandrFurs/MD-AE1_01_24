package pages;

import enums.ItemBarEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;


public interface Page {
    void openPage(ItemBarEnum itembar);

    boolean isOpened();

    void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent);

}

