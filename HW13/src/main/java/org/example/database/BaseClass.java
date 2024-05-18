package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {

    public String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\37529\\IdeaProjects\\MD-AE1_01_24\\HW13\\HW13.db";

    public static Connection conn = null;
    public BaseClass() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("No sql lite driver");
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
