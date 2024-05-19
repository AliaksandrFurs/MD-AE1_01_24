package org.example.utils;

import org.example.entities.Accounts;
import org.example.entities.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BasicVerificationUtils {

    static final BigDecimal balanceLimit = new BigDecimal(2000000000).setScale(2, RoundingMode.HALF_UP);
    static final BigDecimal transactionLimit = new BigDecimal(100000000).setScale(2, RoundingMode.HALF_UP);


    public static boolean isBalanceOk(BigDecimal balance){

        if(balance.compareTo(balanceLimit) > 0 || balance.compareTo(BigDecimal.ZERO) <0){
            return false;
        }
        return true;
    }

    public static boolean isTransactionOk(BigDecimal amount){

        if(amount.compareTo(transactionLimit) > 0 || amount.compareTo(BigDecimal.ZERO) <0){
            return false;
        }
        return true;
    }

    public static boolean isAccountinSuchCurrencyExists(User user, String currency) {

        List<Accounts> userAccountsList = user.getUserAccountsList();

        if (userAccountsList.size() > 0) {
            for (Accounts userAccount : userAccountsList) {
                if (userAccount.getCurrency().equals(currency)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


}



