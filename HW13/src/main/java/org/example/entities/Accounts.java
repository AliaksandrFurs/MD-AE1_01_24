package org.example.entities;

public class Accounts {

    private float balance;
    private String currency;
    private int accountId;

    public float getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setBalance(float balance) {
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
