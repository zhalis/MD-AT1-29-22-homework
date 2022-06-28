package com.it_academy.homework3.services;

import com.it_academy.homework3.dao.AccountDao;
import com.it_academy.homework3.entity.Account;

import java.util.List;

public class AccountServices {

    /**
     * Saves the account to the database
     *
     * @param account to be added to the database
     */
    public static void saveNewAccount(Account account) {
        if (!AccountDao.getExistingAccountsCurrencies(account.getUserId()).contains(account.getCurrency())) {
            AccountDao.saveAccount(account);
        } else {
            throw new IllegalArgumentException("The user has account in this currency");
        }
    }

    /**
     * Account replenishment
     *
     * @param accountId ID of the account to be topped up
     * @param amount    Amount to top up
     */
    public static void accountReplenishment(int accountId, double amount) {
        if (isTopUpPossible(accountId, amount)) {
            TransactionServices.topUpAccount(accountId, amount);
            AccountDao.updateAccount(accountId, amount);
        } else {
            throw new IllegalArgumentException("Account balance exceeded\n Maximum allowable top-up amount: "
                    + (2_000_000_000 - getAccountBalance(accountId)));
        }
    }

    /**
     * Account withdrawal
     *
     * @param accountId ID of the account from which you want to withdraw money
     * @param amount    Amount to be withdrawn
     */
    public static void accountWithdrawal(int accountId, double amount) {
        if (isWithdrawPossible(accountId, amount)) {
            TransactionServices.topUpAccount(accountId, (amount * -1));
            AccountDao.updateAccount(accountId, (amount * -1));
        } else {
            throw new IllegalArgumentException("Insufficient funds in the account\n " +
                    "Current balance" + getAccountBalance(accountId));
        }
    }

    /**
     * Read all accounts from database
     */
    public static List<Account> readAllAccounts() {
        return AccountDao.readAllAccounts();
    }

    private static double getAccountBalance(int accountId) {
        double balance = 0;
        if (AccountDao.readAccount(accountId).isPresent()) {
            balance = AccountDao.readAccount(accountId).get().getBalance();
        }
        return balance;
    }

    private static boolean isTopUpPossible(int accountId, double amount) {
        return (getAccountBalance(accountId) + amount) <= 2_000_000_000;
    }

    private static boolean isWithdrawPossible(int accountId, double amount) {
        return (getAccountBalance(accountId) - amount) >= 0;
    }
}
