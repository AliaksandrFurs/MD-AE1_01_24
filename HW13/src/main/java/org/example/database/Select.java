package org.example.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends BaseClass{

    PreparedStatement preStatement = null;

    public ResultSet selectUserRecord(String name){

        ResultSet resultSet = null;
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(SELECT_USER_STRING);
            preStatement.setString(1, name);
            resultSet = preStatement.executeQuery();
            return resultSet;

        }catch(SQLException e){
            System.out.println("Unable select users from  DB");
        }finally{
            closeConnection();
        }
        return  resultSet;
    }

}
