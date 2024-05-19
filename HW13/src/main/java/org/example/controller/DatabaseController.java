package org.example.controller;

import org.example.database.Create;
import org.example.database.Select;
import org.example.utils.DatabaseCommonUtils;
import org.example.utils.DatabaseVerificationUtils;
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

        int userId = DatabaseCommonUtils.getUserIdFromResultSet(userName);
        boolean isUserExists = DatabaseVerificationUtils.isUserRecordExists(userName);
        boolean isAccountInCurrencyExists = DatabaseVerificationUtils.isAccountInSuchCurrencyExists(currency);

        if (isUserExists == true && isAccountInCurrencyExists == false) {
            create.createAccountRecord(userId,balance,currency);
            return  true;

        }else{
            Print.consolePrint("Unable to create account");
        }
        return false;
    }

    public  void createTransaction(){


    }
}

