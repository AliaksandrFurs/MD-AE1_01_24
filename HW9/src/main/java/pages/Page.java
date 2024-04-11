package pages;

import enums.ItemBarEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;

import java.util.ArrayList;

public interface Page {
    public abstract void openPage(ItemBarEnum itembar);

    public abstract boolean isOpened();

    public abstract void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent);

}

