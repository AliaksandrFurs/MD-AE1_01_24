package enums;

public enum ProducentEnum {

    SAMSUNG("Samsung"),
    LG("LG");

    private final String value;

    ProducentEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
