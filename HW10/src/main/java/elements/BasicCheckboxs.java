package elements;

import enums.product.ProductPageProducentEnum;

public abstract class BasicCheckboxs {

    public String name;

    public abstract String getCheckboxTypeName();

    public abstract void selectCheckbox(ProductPageProducentEnum producent);

    public abstract BasicCheckboxs getCheckbox();
}
