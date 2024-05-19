package org.example.database;

import org.example.utils.Print;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\37529\\IdeaProjects\\MD-AE1_01_24\\HW13\\HW13.db";
    public static final String INSERT_USER_STRING = "INSERT INTO USERS (name, address) VALUES (?, ?)";
    public static final String SELECT_USER_STRING = "SELECT * FROM USERS WHERE name=?";
    public static final String SELECT_ACCOUNT_STRING = "SELECT accountId, name, currency FROM Users e JOIN Accounts d ON e.userId=d.userId WHERE d.currency=?";
    public static final String INSERT_ACCOUNT_STRING = "INSERT INTO ACCOUNTS (userId, balance, currency) VALUES (?, ?, ?)";
    public static final String INSERT_TRANSACTION_STRING = "INSERT INTO TRANSACTIONS (accountId, amount) VALUES (?, ?)";
    public static final String UPDATE_ACCOUNT_SUM_STRING = "UPDATE ACCOUNTS SET balance=? WHERE accountId=?";

    public static Connection conn = null;
    public BaseClass() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            Print.consolePrint("No sql lite driver");
        }
    }

    public void closeConnection(){

        try{
            if(conn!=null){
                conn.close();
            }
        }catch(SQLException e){

        }
    }
}
