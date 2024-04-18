package pages.interfaces;

import enums.BarTypeEnum;
import enums.catalogue.CatalogueNavigationBarEnum;

public interface CatalogPageActions {

    void openPage(BarTypeEnum enumType, CatalogueNavigationBarEnum pageName);

    void isOpened();

    void goToMain();

    void skipConsents();
}
