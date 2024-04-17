package pages;


import enums.BarTypeEnum;
import enums.BarValuesEnum;

public interface BasicActions {
    void openPage(BarTypeEnum enumType, BarValuesEnum pageName);

    void isOpened();

    //void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent);

    void goToMain();

}

