package org.example.database;

import org.example.utils.Print;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends BaseClass{

    PreparedStatement preStatement = null;

    public boolean selectUserRecord(String name){

        ResultSet resultSet;
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(SELECT_USER_STRING);
            preStatement.setString(1, name);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()){
                conn.close();
                return true;
            }
        }catch(SQLException e){
            Print.consolePrint("Unable select users from  DB");
        }
        return  false;
    }

    public boolean selectAccountRecord(String currency){

        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(SELECT_ACCOUNT_STRING);
            preStatement.setString(1, currency);
            resultSet = preStatement.executeQuery();
            while(resultSet.next()){
                conn.close();
                return true;
            }
            return false;
        }catch(SQLException e){
            Print.consolePrint("Unable select accounts from  DB");
        }
        return  false;
    }
}
