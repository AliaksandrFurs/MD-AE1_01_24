package org.example.utils;

import org.example.database.Select;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCommonUtils {

    static Select select = new Select();

    public static int getUserIdFromResultSet(String userName){

        ResultSet resultSet = null;
        int userId;

        try{
            resultSet = select.selectUserRecord(userName);
            userId = resultSet.getInt("userId");
            resultSet.close();
            return userId;

        }catch  (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
