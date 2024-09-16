package elements.interfaces;
import enums.main.MainPageTopBarEnum;

public interface MainBar {

    public abstract void clickOnBar(MainPageTopBarEnum enumValue);

    public abstract boolean isElementPresented(MainPageTopBarEnum elementName);
}
