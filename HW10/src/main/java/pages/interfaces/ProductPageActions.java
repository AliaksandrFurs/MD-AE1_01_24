package pages.interfaces;

import enums.BarTypeEnum;
import enums.main.MainPageProductsNavigationEnum;

public interface ProductPageActions {

    void openPage(BarTypeEnum enumType, MainPageProductsNavigationEnum pageName);

    void isOpened();

    void goToMain();

    void skipConsents();
}
