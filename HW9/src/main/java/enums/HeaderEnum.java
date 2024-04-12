package enums;

public enum HeaderEnum {

    CATALOG("Каталог"),
    NEWS("Нововсти");

    public String getValue() {
        return value;
    }

    private final String value;

    HeaderEnum(String value){
        this.value = value;
    }

}
