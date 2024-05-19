package org.example.entities;

import org.example.controller.DatabaseController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String adress;
    private List<Accounts> userAccountsList = new ArrayList<>();
    //private int userId;

    public User(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }


    public String getAdress() {
        return adress;
    }

    public void addAccount(BigDecimal balance, String currency){

        userAccountsList.add(new Accounts(balance, currency));
    }
}