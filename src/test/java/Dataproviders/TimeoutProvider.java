package Dataproviders;

import org.testng.annotations.DataProvider;

public class TimeoutProvider {

    @DataProvider(name = "basictimeout", parallel = true)
    public Object [][] getTimeoutValues(){
        return new Object [][]{

                {}
        };
    }
}
