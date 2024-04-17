package elements;

import enums.BarTypeEnum;
import enums.BarValuesEnum;

public abstract class BasicBar {

    public String name;

    public abstract String getBarName();

    public abstract void clickOnBar(BarTypeEnum enumType, BarValuesEnum enumValue);

    public abstract BasicBar getBar();
}
