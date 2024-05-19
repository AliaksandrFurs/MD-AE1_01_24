package org.example;

import org.example.controller.EntityController;
import org.example.entities.User;
import org.example.utils.BusinessInteractions;

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

        BigDecimal bd = new BigDecimal(value).setScale(3, RoundingMode.HALF_UP);

        List<User> userList = new ArrayList<>();
        BusinessInteractions.createUser(userList, "Mateusz", "Warshaw");
        BusinessInteractions.createUser(userList, "Alex", "Warshaw");
        //EntityController.addUser(userList, "Mateusz", "Warshaw");
        //EntityController.addAccount(userList, "Mateusz", bd, "EUR");
        //EntityController.addAccount(userList, "Mateusz", bd, "EUR");
        EntityController.addAccount(userList, "Mateusz", bd, "EUR");
        EntityController.addAccount(userList, "Mateusz", bd, "GBP");
        EntityController.addAccount(userList, "Alex", bd, "USD");
        BusinessInteractions.deposit(userList,"Mateusz", "EUR", bd);
        BusinessInteractions.deposit(userList,"Mateusz", "EUR", bd);
        BusinessInteractions.withdraw(userList,"Mateusz", "EUR", bd);






    }
}
