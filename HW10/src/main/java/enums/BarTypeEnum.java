package enums;

public enum BarTypeEnum {
    HEADERBARMAINNAVIGATION ("Header bar main navigation"),
    HEADERBARPRODUCTNAVIGATION("Header bar product navigation"),
    CATALOGUEMAIN ("Catalogue main"),
    CATALOGUENAVIGATION ("Catalogue navigation");

    private final String value;

    public String getValue(){return value;}

    BarTypeEnum(String value){this.value = value;}
}
