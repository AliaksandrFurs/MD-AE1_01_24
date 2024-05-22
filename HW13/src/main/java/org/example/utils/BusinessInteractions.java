package org.example.utils;

import org.example.controller.EntityController;
import org.example.entities.Accounts;
import org.example.entities.Transactions;
import org.example.entities.User;

import java.math.BigDecimal;
import java.util.List;

public class BusinessInteractions {

    public static void withdraw(List<User> userList, String userName, String accountType, BigDecimal amount){

        if(BasicVerificationUtils.isTransactionOk(amount)) {
            if (BasicVerificationUtils.isUserExists(userList, userName)) {
                User user = BasicCommonUtils.getUser(userList, userName);
                if (BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType)){
                    Accounts account = BasicCommonUtils.getAccount(user, accountType);
                    if (BasicVerificationUtils.isFinalSumOk(account.getBalance(), amount, "-")) {
                        BigDecimal newAccountBalance = BasicCommonUtils.newAccountBalance(account.getBalance(), amount, "-");
                        List<Transactions> transaction = EntityController.addTransaction(account, accountType, amount, newAccountBalance);
                        if (transaction != null && transaction.size()==account.getAccountTransactionList().size()+1) {
                            account.setAccountTransactionList(transaction);
                            account.setBalance(newAccountBalance);
                        }else{
                            Print.consolePrint("Unable to create transaction");
                        }
                    }else{
                        Print.consolePrint("Unable to create transaction for " + userName + " for account in " + accountType + " because final sum is invalid");
                    }
                }else{
                    Print.consolePrint("Unable to create transaction for " + userName + " because account in " + accountType + " already exists");
                }
            }else{
                Print.consolePrint("Unable to create transaction for " + userName + " because this user not exists");
            }
        }
    }

    public static void deposit(List<User> userList, String userName, String accountType, BigDecimal amount){

        if(BasicVerificationUtils.isTransactionOk(amount)) {
            if (BasicVerificationUtils.isUserExists(userList, userName)) {
                User user = BasicCommonUtils.getUser(userList, userName);
                if (BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType)){
                    Accounts account = BasicCommonUtils.getAccount(user, accountType);
                    if (BasicVerificationUtils.isFinalSumOk(account.getBalance(), amount, "+")) {
                        BigDecimal newAccountBalance = BasicCommonUtils.newAccountBalance(account.getBalance(), amount, "+");
                        List<Transactions> transaction = EntityController.addTransaction(account, accountType, amount, newAccountBalance);
                        if (transaction != null && transaction.size()==account.getAccountTransactionList().size()+1) {
                            account.setAccountTransactionList(transaction);
                            account.setBalance(newAccountBalance);
                        }else{
                            Print.consolePrint("Unable to create transaction");
                        }
                    }else{
                        Print.consolePrint("Unable to create transaction for " + userName + " for account in " + accountType + " because final sum is invalid");
                    }
                }else{
                    Print.consolePrint("Unable to create transaction for " + userName + " because account in " + accountType + " already exists");
                }
            }else{
                Print.consolePrint("Unable to create transaction for " + userName + " because this user not exists");
            }
        }
    }

    public static void createUser(List<User> userList, String userName, String address){

        if(userList.size() > 0) {
            if (BasicVerificationUtils.isUserExists(userList, userName)) {
                System.out.println("User " + userName + " already exists");
            }else{
                User user = EntityController.addUser(userName, address);
                if(user != null){
                    userList.add(user);
                    Print.consolePrint("User " + userName + " added successfully");
                }else{
                    Print.consolePrint("User " + userName + " has not been added");
                }
            }
        }else{
            User user = EntityController.addUser(userName, address);
            if(user != null){
                userList.add(user);
                Print.consolePrint("User " + userName + " added successfully");
            }else{
                Print.consolePrint("User " + userName + " has not been added");
            }
        }
    }

    public static void createAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        if(BasicVerificationUtils.isBalanceOk(balance)){
            if(BasicVerificationUtils.isUserExists(userList, userName)){
                User user = BasicCommonUtils.getUser(userList, userName);
                if(BasicVerificationUtils.isAccountInSuchCurrencyExists(user, currency) == false){
                    Accounts account = EntityController.addAccount(user, balance, currency);
                    if(account != null){
                        List<Accounts> accountsList = user.getUserAccountsList();
                        accountsList.add(account);
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
