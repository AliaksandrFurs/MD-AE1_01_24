package elements.interfaces;

import enums.main.MainPageProductsNavigationEnum;

public interface MainProductNavigationBar {

    public abstract void clickOnBar(MainPageProductsNavigationEnum enumValue);

    public abstract boolean isElementPresented(MainPageProductsNavigationEnum elementName);
}
