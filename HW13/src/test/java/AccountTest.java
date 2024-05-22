import org.example.utils.BasicVerificationUtils;
import org.example.utils.BusinessInteractions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class AccountTest extends BaseTest{

    @BeforeClass
    public void AddUsersToDb(){
        BusinessInteractions.createUser(userList, testUser.getName(), testUser.getAdress());
    }

    @Test
    public void addSingleAccount(){

        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "EUR");
        Assert.assertTrue(BasicVerificationUtils.isAccountInSuchCurrencyExists(TestUtils.getUserByName(userList, testUser.getName()), "EUR"), "No account in such currency exists");
    }

    @Test
    public void addAccountWithExistingCurrency(){
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "USD");
        BusinessInteractions.createAccount(userList, testUser.getName(), new BigDecimal(800), "USD");
        Assert.assertFalse(BasicVerificationUtils.isAccountInSuchCurrencyExists(TestUtils.getUserByName(userList, testUser.getName()), "EUR"), "No account in such currency exists");
    }

    @Test
    @DataProvider
    public void addAccountWithInvalidBalance(){

    }
}
