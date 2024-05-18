package org.example;

import org.example.controller.CreateEntity;
import org.example.controller.EntityController;
import org.example.database.Create;
import org.example.entities.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        double value= 255.96;

        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);

        List<User> userList = new ArrayList<>();
        userList.add(new User("AlexFursNew", "Test"));
        EntityController.addAccount(userList, "sdfgsdfg", bd, "EUR");





    }
}
