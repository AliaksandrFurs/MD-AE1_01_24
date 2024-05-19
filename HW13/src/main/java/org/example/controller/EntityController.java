package org.example.controller;

import org.example.entities.Accounts;
import org.example.entities.User;
import org.example.utils.BasicCommonUtils;
import org.example.utils.BasicVerificationUtils;
import org.example.utils.Print;

import java.math.BigDecimal;
import java.util.List;

public class EntityController {

    public static void addAccount(List<User> userList, String userName, BigDecimal balance, String currency){

        boolean isBalanceOk = BasicVerificationUtils.isBalanceOk(balance);
        boolean isAccountinSuchCurrencyExists = true;
        User user;

        if(isBalanceOk){
                if(BasicVerificationUtils.isUserExists(userList, userName)){
                    user = BasicCommonUtils.getUser(userList, userName);
                    isAccountinSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, currency);
                    if(isAccountinSuchCurrencyExists == false) {
                        boolean isRecordInserted = DatabaseController.createAccount(userName, balance, currency);
                        if(isRecordInserted) {
                            user.addAccount(balance, currency);
                            Print.consolePrint("Account created successfully");
                        }else{
                            Print.consolePrint("Unable to create account due to DB issue");
                        }
                    }else{
                        Print.consolePrint("Account in such currency already exists. Unable to create another one");
                    }
                }else{
                    Print.consolePrint("User does not exists. Unable to create account");
                }
        }else{
            Print.consolePrint("Account balance is invalid");
        }

    }

    public static void addUser(List<User> userList, String userName, String address){

        if(userList.size() > 0){
                if(BasicVerificationUtils.isUserExists(userList, userName)){
                    System.out.println("User already exists");
                }else{
                    DatabaseController.createUser(userName, address);
                    userList.add(new User(userName, address));
                    System.out.println("User added successfully");
                }

        }else{
            DatabaseController.createUser(userName, address);
            userList.add(new User(userName, address));
            System.out.println("User added successfully");
        }
    }

    public static void addTransaction(List<User> userList, String userName, String accountType, String operationType, BigDecimal amount){

        boolean isTransactionOk = BasicVerificationUtils.isTransactionOk(amount);
        boolean isUserExists = BasicVerificationUtils.isUserExists(userList, userName);
        boolean isAccountInSuchCurrencyExists;
        User user;
        boolean isFinalSumOk;

        if(isTransactionOk && isUserExists){
            user = BasicCommonUtils.getUser(userList, userName);
            isAccountInSuchCurrencyExists = BasicVerificationUtils.isAccountInSuchCurrencyExists(user, accountType);
            if(isAccountInSuchCurrencyExists){
                Accounts userAccount = BasicCommonUtils.getAccount(user,accountType);
                isFinalSumOk = BasicVerificationUtils.isFinalSumOk(userAccount.getBalance(), amount, operationType);
                if(isFinalSumOk){
                    userAccount.setBalance(BasicCommonUtils.newAccountBalance(userAccount.getBalance(), amount, operationType));
                    DatabaseController.createTransaction(userName,accountType, amount);
                    DatabaseController.updateBalance(userName, accountType, userAccount.getBalance());
                    Print.consolePrint("Transaction acreated successfully. Balance updated");
                }else{
                    Print.consolePrint("Final account sum is invalid. Transaction prohibited");
                }
            }else{
                Print.consolePrint("No account in such currency exists");
            }
        }else{
            System.out.println("Amount transaction is invalid or user not exists");
        }
    }
}
