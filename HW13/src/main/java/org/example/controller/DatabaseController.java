package org.example.controller;

import org.example.database.Create;
import org.example.database.Select;
import org.example.utils.Print;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseController {

    static Create create = new Create();
    static Select select = new Select();

    public DatabaseController() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("No sql lite driver");
        }
    }

    public static void createUser(String userName, String address) {

        ResultSet resultSet = null;

        try {
            resultSet = select.selectUserRecord(userName);

            if (resultSet.next() == false) {
                create.createUserRecord(userName, address);

            } else {
                Print.consolePrint("Unable to create user");
            }

        } catch (SQLException e) {

        }

    }

    public static boolean createAccount(String userName, BigDecimal balance, String currency) {

        ResultSet userResultSet = null;
        ResultSet accountResultSet = null;
        boolean isUserExists = false;
        boolean isAccountInCurrencyExists = true;

        try {
            userResultSet = select.selectUserRecord(userName);
            accountResultSet = select.selectAccountRecord(currency);

            if (userResultSet.next()) {
                isUserExists = true;

            } else {
                isUserExists = false;
            }

            if (accountResultSet.next()) {
                isAccountInCurrencyExists = true;

            } else {
                isAccountInCurrencyExists = false;
            }

        } catch (SQLException e) {

        }
        if (isUserExists == true && isAccountInCurrencyExists == false) {
            try{
                create.createAccountRecord(userResultSet.getInt("userId"),balance,currency);
                return  true;

            }catch(SQLException e ){
                Print.consolePrint("Account alreaaady exists in DB");
                return false;

            }

        }else{
            Print.consolePrint("SMTH goes wrong");
        }
        return false;
    }

    public  void createTransaction(){


    }
}

