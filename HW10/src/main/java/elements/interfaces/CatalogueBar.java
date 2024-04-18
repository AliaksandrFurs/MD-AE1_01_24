package elements.interfaces;

import enums.catalogue.CatalogueNavigationBarEnum;

public interface CatalogueBar {

    public abstract void clickOnBar(CatalogueNavigationBarEnum enumValue);

    public abstract boolean isElementPresented(CatalogueNavigationBarEnum elementName);
}
