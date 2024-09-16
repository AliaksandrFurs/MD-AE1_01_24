package pages.interfaces;

import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;

public interface MainPageActions {


    void openPage(BarTypeEnum enumType, MainPageTopBarEnum pageValue);

    void isOpened();

    void goToMain();

    void skipConsents();
}
