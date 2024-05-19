package org.example.utils;

import org.example.database.Select;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCommonUtils {

    static Select select = new Select();

    public static int getUserIdFromResultSet(String userName){

        ResultSet userResultSet;
        int userId;

        try{
            userResultSet = select.selectUserRecord(userName);
            userId = userResultSet.getInt("userId");
            userResultSet.close();
            return userId;

        }catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAccountIdFromResultSet(int userId, String currency){
        ResultSet accountResultSet;
        int accountId;

        try{
            accountResultSet = select.selectAccountRecord(currency);
            accountId = accountResultSet.getInt("accountId");
            accountResultSet.close();
            return accountId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
