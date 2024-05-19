package org.example.controller;

import org.example.entities.Accounts;
import org.example.entities.User;
import org.example.utils.BasicVerificationUtils;

import java.math.BigDecimal;
import java.util.List;

public class EntityController {

    public static void addAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        boolean isBalanceOk = BasicVerificationUtils.isBalanceOk(balance);
        boolean isAccountinSuchCurrencyExists = true;

        if(isBalanceOk == true){
            for(User user : userList){
                if(user.getName().equals(userName)){
                    isAccountinSuchCurrencyExists = BasicVerificationUtils.isAccountinSuchCurrencyExists(user, currency);
                    if(isAccountinSuchCurrencyExists == false) {
                        boolean isRecordInserted = DatabaseController.createAccount(userName, balance, currency);
                        if(isRecordInserted == true) {
                            user.addAccount(balance, currency);
                            System.out.println("Account created successfully");
                        }else{
                            System.out.println("Unable to create account");
                        }
                    }else{
                        System.out.println("Unable to create account");
                    }
                }
            }
        }else{
            System.out.println("Unable to create account");
        }

    }

    public static void addUser(List<User> userList, String userName, String address){

        if(userList.size() > 0){
            for(User user: userList){
                if(user.getName().equals(userName)){
                    System.out.println("User already exists");
                }else{
                    DatabaseController.createUser(userName, address);
                    userList.add(new User(userName, address));
                    System.out.println("User added successfully");
                }
            }
        }else{
            DatabaseController.createUser(userName, address);
            userList.add(new User(userName, address));
            System.out.println("User added successfully");
        }
    }
}
