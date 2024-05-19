package org.example.utils;

import org.example.database.Select;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseVerificationUtils {

    static Select select = new Select();

    public static  boolean isUserRecordExists(String userName){

        ResultSet userResultSet = null;

        try {
            userResultSet = select.selectUserRecord(userName);

            if (userResultSet.next()) {
                userResultSet.close();
                return true;

            } else {
                userResultSet.close();
                return false;
            }

        } catch (SQLException e) {

        }
       return true;
    }

    public static boolean isAccountInSuchCurrencyExists(String currency){

        ResultSet accountResultSet = null;

        try {
            accountResultSet = select.selectAccountRecord(currency);

            if (accountResultSet.next()) {
                accountResultSet.close();
                return true;

            } else {
                accountResultSet.close();
                return false;
            }

        } catch (SQLException e) {

        }
        return true;
    }
}
