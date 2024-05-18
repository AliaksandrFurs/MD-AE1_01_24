package org.example.database;

import org.example.entities.User;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class Create extends BaseClass{

    Statement statement = null;
    PreparedStatement preStatement = null;

    public Create() {
        super();
    }

    public void createDatabase(String databaseName){

        try{
            conn = DriverManager.getConnection(String.format(CONNECTION_STRING, databaseName));
            statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS Users (userId integer PRIMARY KEY NOT NULL, name text NOT NULL, address text)");
            statement.execute("CREATE TABLE IF NOT EXISTS Accounts (accountId integer PRIMARY KEY NOT NULL, userId integer NOT NULL, balance decimal NOT NULL, currency text NOT NULL, FOREIGN KEY (userId) REFERENCES Users (userId))");
            statement.execute("CREATE TABLE IF NOT EXISTS Transactions (transactionId integer PRIMARY KEY NOT NULL," +
                    "accountId integer NOT NULL, amount decimal NOT NULL, FOREIGN KEY (accountId) REFERENCES Accounts (accountId))");

        }catch(SQLException e){
            System.out.println("Unable to create DB");
        }finally{
            closeConnection();
        }

    }

    public void createUser(String userName, String address){

        try{
            conn.close();
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(INSERT_USER_STRING);
            preStatement.setString(1, userName);
            preStatement.setString(2, address);
            preStatement.executeUpdate();
            System.out.println("User created successfully");

        }catch(SQLException e){
            System.out.println("Unable to insert users to  DB");
        }
    }

    public void createAccount(int userId, BigDecimal balance, String currency){

        try{
            conn.close();
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(INSERT_ACCOUNT_STRING);
            preStatement.setInt(1, userId);
            preStatement.setBigDecimal(2, balance);
            preStatement.setString(3, currency);
            preStatement.executeUpdate();
            System.out.println("Account inserted to DB");

        }catch(SQLException e){
            System.out.println("Unable to insert account to  DB");
        }

    }

    public void createTransaction(int accountId, BigDecimal amount){

        try{
            conn.close();
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(INSERT_TRANSACTION_STRING);
            preStatement.setInt(1, accountId);
            preStatement.setBigDecimal(2, amount);
            preStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println("Unable to insert transaction to  DB");
        }

    }
}
