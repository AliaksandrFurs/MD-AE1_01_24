package org.example.controller;

import org.example.entities.Accounts;
import org.example.entities.User;

import java.math.BigDecimal;
import java.util.List;

public class EntityController {

    public static void addAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        for(User user : userList){
            if(user.getName().equals(userName)){
                CreateEntity.createAccount(userName, balance, currency);
                user.addAccount(balance,currency);
                System.out.println("Account created successfully");
            }else{
                System.out.println("Unable to create account");
            }

        }
    }
}
