package com.it_academy.homework3.services;

import com.it_academy.homework3.dao.TransactionDao;

public class TransactionServices {

    /**
     * Saves the transaction to the database
     *
     * @param accountId ID of the account in which the transaction is to be performed
     * @param amount    Amount transaction
     */
    public static void topUpAccount(int accountId, double amount) {
        if (amount <= 100_000_000) {
            TransactionDao.saveTransaction(accountId, amount);
        } else {
            throw new IllegalArgumentException("Transaction limit exceeded");
        }
    }
}
