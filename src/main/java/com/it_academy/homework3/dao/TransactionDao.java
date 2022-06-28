package com.it_academy.homework3.dao;

import com.it_academy.homework3.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class TransactionDao {

    /**
     * Saves the transaction to the database
     *
     * @param accountId ID of the account in which the transaction is to be performed
     * @param amount    Amount transaction
     */
    public static void saveTransaction(int accountId, double amount) {
        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Transactions (accountId, amount) VALUES(%d, ",
                    accountId) + amount + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
