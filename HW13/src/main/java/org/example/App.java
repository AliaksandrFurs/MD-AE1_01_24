package org.example;

import org.example.controller.EntityController;
import org.example.entities.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

        double value= 259;

        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);

        List<User> userList = new ArrayList<>();
        EntityController.addUser(userList, "Mateusz", "Warshaw");
        EntityController.addUser(userList, "Mateusz", "Warshaw");
        EntityController.addAccount(userList, "Mateusz", bd, "EUR");
        EntityController.addAccount(userList, "Mateusz", bd, "EUR");





    }
}
