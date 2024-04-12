package elements;

import enums.ProducentEnum;

public abstract class BasicCheckboxs {

    public String name;

    public abstract String getCheckboxTypeName();

    public abstract void selectCheckbox(ProducentEnum producent);

    public abstract BasicCheckboxs getCheckbox();
}
