package org.example.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Accounts {

    private BigDecimal balance;
    private String currency;
    private int accountId;
    private List<Transactions> accountTransactionList = new ArrayList<>();

    public Accounts(BigDecimal balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}