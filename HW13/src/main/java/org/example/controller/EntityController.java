package org.example.controller;

import org.example.entities.Accounts;
import org.example.entities.Transactions;
import org.example.entities.User;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntityController {

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\37529\\IdeaProjects\\MD-AE1_01_24\\HW13\\HW13.db";
    static PreparedStatement preStatement = null;

    public static Accounts addAccount(User user, BigDecimal balance, String currency) {

        if (DatabaseController.createAccount(user, balance, currency)) {
            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
                if (DatabaseController.selectAccountInCurrencyFromUser(currency)) {
                    String selectAccountString = "SELECT accountId, balance, currency, name FROM Users e JOIN Accounts d ON e.userId=d.userId WHERE d.currency=?";
                    preStatement = conn.prepareStatement(selectAccountString);
                    preStatement.setString(1, currency);
                    ResultSet resultSet = preStatement.executeQuery();
                    while (resultSet.next()) {
                        Accounts account = new Accounts(resultSet.getInt("accountId"), resultSet.getBigDecimal("balance"),resultSet.getString("currency"));
                        conn.close();
                        return account;
                    }
                } else {
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
        return null;
    }

    public static User addUser(String userName, String address) {
        if (DatabaseController.createUser(userName, address)) {
            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
                String selectUserString = "SELECT * FROM USERS WHERE name=?";
                preStatement = conn.prepareStatement(selectUserString);
                preStatement.setString(1, userName);
                ResultSet resultSet = preStatement.executeQuery();
                while (resultSet.next()) {
                    User user = new User(resultSet.getInt("userId"), resultSet.getString("name"), resultSet.getString("address"));
                    conn.close();
                    return user;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
        return null;
    }


    public static List<Transactions> addTransaction(Accounts account, String accountType, BigDecimal amount, BigDecimal newAccountBalance) {

        List<Transactions> transactions = new ArrayList<>();
        if (DatabaseController.createTransaction(account, accountType, amount) && DatabaseController.updateBalance(account, accountType, newAccountBalance)) {
            try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
                String selectTransactionString = "SELECT * FROM TRANSACTIONS WHERE accountId =?";
                preStatement = conn.prepareStatement(selectTransactionString);
                preStatement.setInt(1, account.getAccountId());
                ResultSet resultSet = preStatement.executeQuery();
                while (resultSet.next()) {
                    transactions.add(new Transactions(resultSet.getInt("transactionId"), resultSet.getBigDecimal("amount"), resultSet.getInt("accountId")));
                    conn.close();
                    return transactions;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
        return null;
    }
}

