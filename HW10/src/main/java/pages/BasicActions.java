package pages;

import enums.ItemBarEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;


public interface BasicActions {
    void openPage(ItemBarEnum itembar);

    void isOpened();

    //void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent);

    void goToMain();

}

