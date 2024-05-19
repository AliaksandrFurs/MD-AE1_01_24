package org.example.controller;

import org.example.database.Create;
import org.example.database.Select;
import org.example.utils.Print;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseController {

    static Create create = new Create();
    static Select select = new Select();

    public String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\37529\\IdeaProjects\\MD-AE1_01_24\\HW13\\HW13.db";

    public static Connection conn = null;

    public DatabaseController() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("No sql lite driver");
        }
    }

    public static void closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

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

        } finally {
            closeConnection();
        }

    }

    public static boolean createAccount(String userName, BigDecimal balance, String currency) {

        ResultSet resultSet = null;
        boolean isRecordExists = false;

        try {
            resultSet = select.selectUserRecord(userName);

            if (resultSet.next()) {
                isRecordExists = true;

            } else {
                isRecordExists = false;
            }

        } catch (SQLException e) {

        }
        if (isRecordExists == true) {
            try{
                create.createAccountRecord(resultSet.getInt("userId"),balance,currency);
                return  true;

            }catch(SQLException e ){
                Print.consolePrint("Account alreaaady exists in DB");
                return false;

            }finally{
                closeConnection();
            }

        }else{
            Print.consolePrint("SMTH goes wrong");
        }
        return false;
    }

    public  void createTransaction(){


    }
}

