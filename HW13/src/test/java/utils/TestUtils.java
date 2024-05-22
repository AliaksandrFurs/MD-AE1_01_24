package utils;

import org.example.entities.Accounts;
import org.example.entities.User;

import java.util.List;

public class TestUtils {

    public static User getUserByName(List<User> userList, String userName){

        for(User user : userList){
            if(user.getName().equals(userName)){
                return user;
            }
        }
        return  null;
    }

    public static Accounts getUserAccount(List<User> userList, String userName, String accountCurrency){

        User user = getUserByName(userList, userName);

        if(user != null){
            List<Accounts> accountList = user.getUserAccountsList();
            for(Accounts account : accountList){
                if(account.getCurrency().equals(accountCurrency)){
                    return account;
                }
            }
        }
        return null;
    }
}
