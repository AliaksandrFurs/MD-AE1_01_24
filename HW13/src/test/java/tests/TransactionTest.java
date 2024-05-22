package tests;

import dataproviders.AccountDataProvider;
import org.example.utils.BusinessInteractions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.math.BigDecimal;

public class TransactionTest extends BaseTest{

    @BeforeClass
    public void prepareData(){
        BusinessInteractions.createUser(userList, testUser.getName(), testUser.getAdress());
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "EUR");
    }

    @BeforeMethod
    public void setDefaultBalance(){
        TestUtils.getUserAccount(userList, testUser.getName(), "EUR").setBalance(new BigDecimal(800));
    }

    @Test
    public void withdrawTest(){
        BusinessInteractions.withdraw(userList, testUser.getName(), "EUR", new BigDecimal(100));
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(700))==0,
                "Balance is not valid");
    }

    @Test
    public void depositTest(){
        BusinessInteractions.deposit(userList, testUser.getName(), "EUR", new BigDecimal(100));
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(900))==0,
                "Balance is not valid");
    }

    @Test(dataProvider = "withdrow with invalid amount", dataProviderClass = AccountDataProvider.class)
    public void withdrowWithInvalidAmountTest(BigDecimal amount){
        BusinessInteractions.withdraw(userList, testUser.getName(), "EUR", amount);
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(800))==0);
    }

    @Test(dataProvider = "deposit with invalid amount", dataProviderClass = AccountDataProvider.class)
    public void depositWithInvalidAmountTest(BigDecimal amount){
        BusinessInteractions.deposit(userList, testUser.getName(), "EUR", amount);
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(800))==0);
    }

    @Test
    public void withdrawBelowZeroTest(){
        BusinessInteractions.withdraw(userList, testUser.getName(), "EUR", new BigDecimal(900));
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(800))==0);
    }

    @Test
    public void depositAboveLimitTest(){
        BusinessInteractions.deposit(userList, testUser.getName(), "EUR", new BigDecimal(200000000));
        Assert.assertTrue(TestUtils.getUserAccount(userList, testUser.getName(), "EUR").getBalance().compareTo(new BigDecimal(800))==0);
    }
}
