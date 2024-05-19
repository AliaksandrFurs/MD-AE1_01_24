package org.example.utils;

import org.example.controller.EntityController;
import org.example.entities.User;

import java.math.BigDecimal;
import java.util.List;

public class BusinessInteractions {

    public static void withdraw(List<User> userList, String userName, String accountType, BigDecimal amount){

        boolean isTransactionOk = BasicVerificationUtils.isTransactionOk(amount);
        boolean isUserExists = BasicVerificationUtils.isUserExists(userList, userName);
        User user;

        if(isTransactionOk) {
            if (isUserExists) {
                user = BasicCommonUtils.getUser(userList, userName);
                boolean isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType);
                if (isAccountInSuchCurrencyExists) {
                    EntityController.addTransaction(user, accountType, "-", amount);
                }
            } else {
                Print.consolePrint("User does not exists");
            }
        }else{
            Print.consolePrint("Transaction amount is invalid. Unable to perform transaction");
        }

    }

    public static void deposit(List<User> userList, String userName, String accountType, BigDecimal amount){

        boolean isTransactionOk = BasicVerificationUtils.isTransactionOk(amount);
        boolean isUserExists = BasicVerificationUtils.isUserExists(userList, userName);
        User user;

        if(isTransactionOk) {
            if (isUserExists) {
                user = BasicCommonUtils.getUser(userList, userName);
                boolean isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType);
                if (isAccountInSuchCurrencyExists) {
                    EntityController.addTransaction(user, accountType, "+", amount);
                }
            } else {
                Print.consolePrint("User does not exists");
            }
        }else{
            Print.consolePrint("Transaction amount is invalid. Unable to perform transaction");
        }
    }

    public static void createUser(List<User> userList, String userName, String address){

        if(userList.size() > 0) {
            if (BasicVerificationUtils.isUserExists(userList, userName)) {
                System.out.println("User already exists");
            }
        }else{
            EntityController.addUser(userList, userName, address);
        }
    }
}
