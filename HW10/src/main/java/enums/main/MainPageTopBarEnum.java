package enums.main;

public enum MainPageTopBarEnum {

    SMARTPHONE("Смартфоны"),
    TV("Телевизоры"),
    CATALOG("Каталог"),
    NEWS("Нововсти");


    public String getValue() {
        return value;
    }

    private final String value;

    MainPageTopBarEnum(String value){
        this.value = value;
    }
}
