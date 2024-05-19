package org.example.controller;

import org.example.entities.User;
import org.example.utils.DatabaseUtils;

import java.math.BigDecimal;
import java.util.List;

public class EntityController {

    public static void addAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        boolean isBalanceOk = DatabaseUtils.isBalanceOk(balance);

        for(User user : userList){
            if(user.getName().equals(userName) && isBalanceOk == true){
                DatabaseController.createAccount(userName, balance, currency);
                user.addAccount(balance,currency);
                System.out.println("Account created successfully");
            }else{
                System.out.println("Unable to create account");
            }

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
