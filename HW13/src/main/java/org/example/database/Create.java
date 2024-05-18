package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create extends BaseClass{

    Statement statement = null;

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


}
