package org.example;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Account {
    private final String accountNumber;
    private BigDecimal accountBalance;
//    private final Client customer;
    List<Client> customers = new LinkedList<>();

    public Account(String accountNumber, List<Client> customers, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.customers = customers;
        this.accountBalance = accountBalance;
    }

    public void depositeMoney(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            accountBalance = accountBalance.add(amount);
        }
    }

    public boolean withdrawMoney(BigDecimal amount) {
        if (accountBalance.compareTo(amount) >= 1) {
            accountBalance = accountBalance.subtract(amount);
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", customer=" + customers +
                '}';
    }
}
