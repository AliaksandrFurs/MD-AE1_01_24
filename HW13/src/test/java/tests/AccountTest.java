package tests;

import dataproviders.AccountDataProvider;
import org.example.utils.BasicVerificationUtils;
import org.example.utils.BusinessInteractions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.math.BigDecimal;

public class AccountTest extends BaseTest {

    @BeforeClass
    public void prepareData(){
        BusinessInteractions.createUser(userList, testUser.getName(), testUser.getAdress());
    }

    @Test
    public void addSingleAccountTest(){
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "EUR");
        Assert.assertTrue(BasicVerificationUtils.isAccountInSuchCurrencyExists(TestUtils.getUserByName(userList, testUser.getName()), "EUR"), "No account in such currency exists");
    }

    @Test
    public void addAccountWithExistingCurrencyTest(){
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "USD");
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "USD");
        Assert.assertFalse(BasicVerificationUtils.isAccountInSuchCurrencyExists(TestUtils.getUserByName(userList, testUser.getName()), "EUR"), "No account in such currency exists");
    }

    @Test(dataProvider = "accoutnt with invalid balance", dataProviderClass = AccountDataProvider.class)
    public void addAccountWithInvalidBalanceTest(BigDecimal balance){
        BusinessInteractions.createAccount(userList, testUser.getName(), balance, "GBP");
        Assert.assertFalse(BasicVerificationUtils.isAccountInSuchCurrencyExists(TestUtils.getUserByName(userList, testUser.getName()), "GBP"), "No account in such currency exists");
    }

    @Test
    public void addAccountForUnexistingUserTest(){
        BusinessInteractions.createAccount(userList, "User not exists", new BigDecimal(800), "GBP");
        Assert.assertFalse(BasicVerificationUtils.isUserExists(userList, "User not exists"), "User exists");

    }
}
