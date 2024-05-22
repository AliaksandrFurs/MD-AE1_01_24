package dataproviders;

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

public class AccountDataProvider {

    @DataProvider(name = "accoutnt with invalid balane")
    public Object[][] invalidBalance() {
        return new Object[][] {
                {new BigDecimal(-1)},
                {new BigDecimal(2000000001)}
        };
    }

    @DataProvider(name = "withdrow with invalid amount")
    public Object [][] invalidWithdrow(){
        return new Object[][]{
                {new BigDecimal(200000000)},
                {new BigDecimal(-100)}
        };
    }

    @DataProvider(name = "deposit with invalid amount")
    public Object [][] invalidDeposit(){
        return new Object[][]{
                {new BigDecimal(200000000)},
                {new BigDecimal(-100)}
        };
    }
}
