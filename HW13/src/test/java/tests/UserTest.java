package tests;

import org.example.utils.BasicVerificationUtils;
import org.example.utils.BusinessInteractions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    @Test(description = "Acc single user test")
    public void addSingleUserTest(){
        BusinessInteractions.createUser(userList, testUser.getName(), testUser.getAdress());
        Assert.assertTrue(BasicVerificationUtils.isUserExists(userList, testUser.getName()), "User not exists");
    }

    @Test(description = "Add existing in DB user")
    public void addExistingUserTest(){
        BusinessInteractions.createUser(userList, testUser.getName(), testUser.getAdress());
        Assert.assertTrue(BasicVerificationUtils.isUserExists(userList, testUser.getName()), "User exists");
    }

    @Test
    public void addUserWithoutAdressTest(){
        BusinessInteractions.createUser(userList, "Alex", null);
        Assert.assertTrue(BasicVerificationUtils.isUserExists(userList, "Alex"), "Adress is not null");
    }
}
