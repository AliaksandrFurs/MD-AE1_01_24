package Dataproviders;

import org.testng.annotations.DataProvider;

public class TrigonometricalDataProvider {

    @DataProvider(name = "cosbasic", parallel = true)
    public Object[][] getCosValues() {
        return new Object[][]{
                {0.0, 1.0},
                {90.0, 0.0},
                {180.0, -1.0}
        };
    }

    @DataProvider(name = "sinbasic", parallel = true)
    public Object[][] getSinValues() {
        return new Object[][]{
                {0.0, 0.0},
                {30.0, 0.5},
                {90.0, 1.0}
        };
    }

    @DataProvider(name = "tgbasic", parallel = true)
    public Object[][] getTgValues() {
        return new Object[][]{
                {0.0, 0.0},
                {45.0, 1.0}
        };
    }

    @DataProvider(name = "ctgbasic", parallel = true)
    public Object[][] getCtgValues() {
        return new Object[][]{
                {90.0, 0.0},
                {45.0, 1.0},
                {270.0, 0.0}
        };
    }
}
