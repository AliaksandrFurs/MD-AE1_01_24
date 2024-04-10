package pages;

import enums.ItemBarEnum;
import enums.ProducentEnum;

public interface Page {
    public abstract void openPage(ItemBarEnum itembar);

    public abstract boolean isOpened();

    public abstract void selectCheckbox(ProducentEnum producent);
}

