package elements.interfaces;

import enums.catalogue.CatalogueNavigationBarEnum;

public interface CatalogueBar {

    public abstract  void clickOnBar(CatalogueNavigationBarEnum enumType);

    public abstract  boolean isElementPresented(CatalogueNavigationBarEnum enumType);
}
