package org.example;

import java.math.BigDecimal;
import java.util.*;

public class BankService {
    private final List<Account> accounts = new LinkedList<>();

    public String openAccount(List<Client> customer) {
        String accountNumber = UUID.randomUUID().toString();
        Account newAccount = new Account(accountNumber, customer, BigDecimal.ZERO);
        accounts.add(newAccount);
        return accountNumber;
    }

    public void moneyTransfer(String firstAccountNumber, String secondAccountNumber, BigDecimal amount) throws Exception {
        Account firstAccount = searchAccount(firstAccountNumber);
        Account secondAccount = searchAccount(secondAccountNumber);

        if (firstAccount == null) {
            throw new Exception("Account doesn't exists");
        }

        if (secondAccount == null) {
            throw new Exception("No matching account found");
        }

        boolean withdrawResult = firstAccount.withdrawMoney(amount);
        if (withdrawResult) {
            secondAccount.depositeMoney(amount);
        }
    }

    private Account searchAccount(String accountNumber) {
        return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

}
