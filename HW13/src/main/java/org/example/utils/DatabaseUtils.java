package org.example.utils;

import java.math.BigDecimal;

public class DatabaseUtils {


    public static boolean isBalanceOk(BigDecimal balance){

        if(balance.toBigInteger().intValueExact() > 2000000000){
            return false;
        }
        if(balance.toBigInteger().intValueExact() < 0){
            return false;
        }
        return true;
    }
}
