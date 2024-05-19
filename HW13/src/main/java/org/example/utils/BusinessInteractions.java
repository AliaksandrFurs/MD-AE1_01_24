package org.example.utils;

import org.example.controller.DatabaseController;
import org.example.controller.EntityController;
import org.example.entities.Accounts;
import org.example.entities.Transactions;
import org.example.entities.User;

import java.math.BigDecimal;
import java.util.List;

public class BusinessInteractions {

    static List<Transactions> accountTransactions;
    static List<Accounts> accountsList;
    static User user;
    static boolean isUserExists;
    static boolean isTransactionOk;
    static boolean isAccountInSuchCurrencyExists;
    static boolean isBalanceOk;

    public static void withdraw(List<User> userList, String userName, String accountType, BigDecimal amount){

        isTransactionOk = BasicVerificationUtils.isTransactionOk(amount);
        isUserExists = BasicVerificationUtils.isUserExists(userList, userName);

        if(isTransactionOk) {
            if (isUserExists) {
                user = BasicCommonUtils.getUser(userList, userName);
                isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType);
                if (isAccountInSuchCurrencyExists) {
                    if(EntityController.addTransaction(user, accountType, "-", amount)){
                        Accounts userAccount = BasicCommonUtils.getAccount(user, accountType);
                        accountTransactions = userAccount.getAccountTransactionList();
                        accountTransactions.add(new Transactions(amount));
                        //accountTransactions.clear();
                        Print.consolePrint("Transaction: " + amount + " " + userAccount.getCurrency() + " for user " + user.getName() + " created successfully. Balance updated");
                    }
                }
            } else {
                Print.consolePrint("User " + userName + " does not exists");
            }
        }else{
            Print.consolePrint("Transaction amount " + amount+ " is invalid. Unable to perform transaction");
        }

    }

    public static void deposit(List<User> userList, String userName, String accountType, BigDecimal amount){

        isTransactionOk = BasicVerificationUtils.isTransactionOk(amount);
        isUserExists = BasicVerificationUtils.isUserExists(userList, userName);

        if(isTransactionOk) {
            if (isUserExists) {
                user = BasicCommonUtils.getUser(userList, userName);
                isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType);
                if (isAccountInSuchCurrencyExists) {
                    if(EntityController.addTransaction(user, accountType, "+", amount)){
                        Accounts userAccount = BasicCommonUtils.getAccount(user, accountType);
                        accountTransactions = userAccount.getAccountTransactionList();
                        accountTransactions.add(new Transactions(amount));
                        //accountTransactions.clear();
                        Print.consolePrint("Transaction: " + amount + " " + userAccount.getCurrency() + " for user " + user.getName() + " created successfully. Balance updated");
                    }
                }else{
                    Print.consolePrint("Account for user " + userName + " already exists");
                }
            } else {
                Print.consolePrint("User " + userName +" does not exists");
            }
        }else{
            Print.consolePrint("Transaction amount " + amount + " is invalid. Unable to perform transaction");
        }
    }

    public static void createUser(List<User> userList, String userName, String address){

        if(userList.size() > 0) {
            if (BasicVerificationUtils.isUserExists(userList, userName)) {
                System.out.println("User " + userName + " already exists");
            }
        }else{
            if(EntityController.addUser(userName, address)){
                userList.add(new User(userName, address));
                Print.consolePrint("User " + userName + " added successfully");
            }else{
                Print.consolePrint("User " + userName + " has not been added");
            }
        }
    }

    public static void createAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        isBalanceOk = BasicVerificationUtils.isBalanceOk(balance);
        isUserExists = BasicVerificationUtils.isUserExists(userList, userName);

        if(isBalanceOk){
            if(isUserExists){
                user = BasicCommonUtils.getUser(userList, userName);
                isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, currency);
                if(isAccountInSuchCurrencyExists == false){
                    if(EntityController.addAccount(user, balance, currency)){
                        accountsList = user.getUserAccountsList();
                        accountsList.add(new Accounts(balance, currency));
                        //accountsList.clear();
                        Print.consolePrint("Account for user " + userName + " in currency " + currency + " has been created");
                    }
                }else{
                    Print.consolePrint("Account for user " + userName + " in currency " + currency + " already exists");
                }
            }

        }else{

            Print.consolePrint("User " + userName + " balance is invalid");
        }

    }
}
