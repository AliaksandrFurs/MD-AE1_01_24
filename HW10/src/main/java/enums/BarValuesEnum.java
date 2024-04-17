package enums;

public enum BarValuesEnum {

    SMARTPHONE("Смартфоны"),
    TV("Телевизоры"),
    CATALOG("Каталог"),
    NEWS("Нововсти"),
    ELECTONIC("Электроника"),
    COMPUTERS("Компьютеры и сети"),
    TECHNICS("Бытовая техника"),
    BUILDING("Стройка и ремонт"),
    HOUSE("Дом и сад"),
    AUTO("Авто и мото"),
    PRETTY("Красота и спорт"),
    CHILDREN("Детям и мамам"),
    WORK("Работа и офис"),
    EAT("Еда"),
    LAPTOPS("Ноутбуки, компьютеры, мониторы"),
    PARTS("Комплектующие"),
    DATA("Хранение данных"),
    NETWORK("Сетевое оборудование"),
    GAMES("Игры");


    public String getValue() {
        return value;
    }

    private final String value;

    BarValuesEnum(String value){
        this.value = value;
    }
}
