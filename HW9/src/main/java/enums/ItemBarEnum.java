package enums;

public enum ItemBarEnum {

    SMARTPHONE("Смартфоны"),
    TV("Телевизоры");

    public String getValue() {
        return value;
    }

    private final String value;

    ItemBarEnum(String value){
        this.value = value;
    }
}
