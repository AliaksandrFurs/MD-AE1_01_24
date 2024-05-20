package org.example.utils;

import org.example.database.Select;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseVerificationUtils {

    static Select select = new Select();

    public static  boolean isUserRecordExists(String userName){

        if(select.selectUserRecord(userName)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isAccountInSuchCurrencyExists(String currency){

        if(select.selectAccountRecord(currency)){
            return true;
        }else{
            return false;
        }
    }
}
