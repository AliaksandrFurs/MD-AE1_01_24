package org.example.controller;

import org.example.database.Create;
import org.example.database.Select;
import org.example.database.Update;
import org.example.entities.Accounts;
import org.example.entities.User;
import org.example.utils.DatabaseVerificationUtils;
import org.example.utils.Print;

import java.math.BigDecimal;

public class DatabaseController {

    static Create create = new Create();
    static Select select = new Select();
    static Update update = new Update();

    public DatabaseController() {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("No sql lite driver");
        }
    }

    public static boolean createUser(String userName, String address) {

        if(DatabaseVerificationUtils.isUserRecordExists(userName) == false){
            create.createUserRecord(userName,address);
            return true;
        }else{
            return false;
        }
    }

    public static boolean createAccount(User user, BigDecimal balance, String currency) {

        boolean isUserExists = DatabaseVerificationUtils.isUserRecordExists(user.getName());
        boolean isAccountInCurrencyExists = DatabaseVerificationUtils.isAccountInSuchCurrencyExists(currency);

        if (isUserExists && !isAccountInCurrencyExists) {
            create.createAccountRecord(user.getUserId(),balance,currency);
            return  true;

        }else{
            Print.consolePrint("Unable to create account");
        }
        return false;
    }

    public  static boolean createTransaction(Accounts account, String currency, BigDecimal amount){

        if(DatabaseVerificationUtils.isAccountInSuchCurrencyExists(currency)){
            create.createTransactionRecord(account.getAccountId(), amount);
            return true;
        }else{
            Print.consolePrint("Unable to create transaction");
        }
        return false;
    }

    public static boolean updateBalance(Accounts account, String currency, BigDecimal balance){

        if(DatabaseVerificationUtils.isAccountInSuchCurrencyExists(currency)){
            update.updateAccountBalanceRecord(balance, account.getAccountId());
            return true;
        }else{
            Print.consolePrint("Unable to update account balance");
        }
        return false;
    }

    public static boolean selectAccountInCurrencyFromUser(String currency){

        if(DatabaseVerificationUtils.isAccountInSuchCurrencyExists(currency)){
            return true;
        }else{
            return false;
        }
    }
}

