package org.example.entities;

import java.math.BigDecimal;

public class Transactions {

    private BigDecimal amount;
    private int transactionId;
    private int accountId;

    public Transactions(int transactionId, BigDecimal amount, int accountId){
        this.transactionId = transactionId;
        this.amount = amount;
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
