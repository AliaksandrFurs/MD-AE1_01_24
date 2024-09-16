package pages.interfaces;

import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;

public interface ProductPageActions {

    void openPage(BarTypeEnum enumType, MainPageTopBarEnum pageName);

    void isOpened();

    void goToMain();

    void skipConsents();
}
