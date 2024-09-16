package enums.product;

public enum ProductPageProducentEnum {

    SAMSUNG("Samsung"),
    LG("LG");

    private final String value;

    ProductPageProducentEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
