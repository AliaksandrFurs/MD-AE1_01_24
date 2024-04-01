package Dataproviders;

import org.testng.annotations.DataProvider;

public class TrigonometricalDataProvider {

    @DataProvider(name = "cosbasic", parallel = false)
    public  Object [][] getCosValues(){
        return  new Object [][]{
                {0, 1},
                {90, 0},
                {180, -1}
        };
    }
}
