package org.example.utils;

import org.example.entities.Accounts;
import org.example.entities.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BasicCommonUtils {

    public static User getUser(List<User> userList, String userName){

        for(User user : userList){
            if(user.getName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public static Accounts getAccount (User user, String currency){

        List<Accounts> userAccountsList = user.getUserAccountsList();
        for(Accounts account : userAccountsList){
            if(account.getCurrency().equals(currency)){
                return account;
            }
        }
        return null;
    }

    public static BigDecimal newAccountBalance(BigDecimal currentBalance, BigDecimal amount, String operationType){
        BigDecimal newAccountBalance = new BigDecimal(String.valueOf(currentBalance)).setScale(2, RoundingMode.HALF_UP);
        switch(operationType){
            case "+":
                return newAccountBalance.add(amount);
            case "-":
                return newAccountBalance.subtract(amount);
        }
      return  null;
    }
}
