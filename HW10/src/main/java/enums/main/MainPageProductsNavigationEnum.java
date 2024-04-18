package enums.main;

public enum MainPageProductsNavigationEnum {


    SMARTPHONE("Смартфоны"),
    TV("Телевизоры");

    public String getValue() {
        return value;
    }

    private final String value;

    MainPageProductsNavigationEnum(String value){
        this.value = value;
    }
}
