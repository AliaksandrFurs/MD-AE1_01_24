package Dataproviders;

import org.testng.annotations.DataProvider;

public class PositiveDataProvider {

    @DataProvider(name = "ispositive", parallel = true)
    public Object [][] getPositiveValues (){
        return new Object [][]{
                {0, false},
                {1, true},
                {-1, false}
        };
    }

    @DataProvider(name = "isnegative", parallel = true)
    public Object [][] getNegativeValues (){
        return new Object [][]{
                {0, false},
                {1, false},
                {-1, true}
        };
    }
}
