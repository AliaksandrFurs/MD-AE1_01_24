package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String adress;
    private int userId;
    private List<Accounts> userAccountsList = new ArrayList<>();


    public User(int userId, String name, String adress){
        this.userId = userId;
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Accounts> getUserAccountsList() {
        return userAccountsList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
