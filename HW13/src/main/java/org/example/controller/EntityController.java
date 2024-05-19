package org.example.controller;

import org.example.entities.Accounts;
import org.example.entities.User;
import org.example.utils.BasicCommonUtils;
import org.example.utils.BasicVerificationUtils;
import org.example.utils.Print;

import java.math.BigDecimal;
import java.util.List;

public class EntityController {

    public static boolean addAccount(User user, BigDecimal balance, String currency){

        if(DatabaseController.createAccount(user.getName(), balance ,currency)){
            return true;
        }else{
            return false;
        }
    }



    public static boolean addUser(String userName, String address){

        if(DatabaseController.createUser(userName, address)){
            return true;
        }else{
            return false;
        }
    }



    public static boolean addTransaction(User user, String accountType, String operationType, BigDecimal amount){

        Accounts userAccount = BasicCommonUtils.getAccount(user,accountType);
        boolean isFinalSumOk = BasicVerificationUtils.isFinalSumOk(userAccount.getBalance(), amount, operationType);

        if(isFinalSumOk){
            if(DatabaseController.createTransaction(user.getName(),accountType, amount) && DatabaseController.updateBalance(user.getName(), accountType, userAccount.getBalance())){
                userAccount.setBalance(BasicCommonUtils.newAccountBalance(userAccount.getBalance(), amount, operationType));
                userAccount.setBalance(BasicCommonUtils.newAccountBalance(userAccount.getBalance(), amount, operationType));
                return true;
            }else{
                Print.consolePrint("Transaction: " + amount + " " +userAccount.getCurrency() + " for user" + user.getName() + " does not created");
                return false;
            }

        }else{
            Print.consolePrint("Final account sum is invalid. Transaction prohibited");
        }
        return false;
    }
}

