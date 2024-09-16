package dataproviders;

import enums.catalogue.CatalogueNavigationBarEnum;
import org.testng.annotations.DataProvider;

public class CatalogueTestDataProvider {

    @DataProvider(name = "cataloguebartest")
    public Object [][] getValuesCatalogueBar(){

        return new Object [][]{

                {CatalogueNavigationBarEnum.ELECTRONIC},
                {CatalogueNavigationBarEnum.TECHNICS},
                {CatalogueNavigationBarEnum.COMPUTERS},
                {CatalogueNavigationBarEnum.BUILDING},
                {CatalogueNavigationBarEnum.HOUSE},
                {CatalogueNavigationBarEnum.AUTO},
                {CatalogueNavigationBarEnum.PRETTY},
                {CatalogueNavigationBarEnum.CHILDREN},
                {CatalogueNavigationBarEnum.WORK},
                {CatalogueNavigationBarEnum.EAT}

        };
    }

    @DataProvider(name = "cataloguenavigationbartest")
    public Object [][] getValuesVatalogueNavigation(){

        return new Object [][]{

                {CatalogueNavigationBarEnum.LAPTOPS},
                {CatalogueNavigationBarEnum.PARTS},
                {CatalogueNavigationBarEnum.DATA},
                {CatalogueNavigationBarEnum.NETWORK},
                {CatalogueNavigationBarEnum.GAMES}

        };
    }
}
