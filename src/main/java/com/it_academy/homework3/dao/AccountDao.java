package com.it_academy.homework3.dao;

import com.it_academy.homework3.entity.Account;
import com.it_academy.homework3.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

public class AccountDao {

    /**
     * Add an account to the database
     *
     * @param account to be added to the database
     */
    public static void saveAccount(Account account) {
        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Accounts (userId, balance, currency) " +
                            "VALUES(%d, " + account.getBalance() + ", '%s')",
                    account.getUserId(), account.getCurrency()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Update data in the database
     *
     * @param accountId Id on which to update the data
     * @param amount    data to be updated
     */
    public static void updateAccount(int accountId, double amount) {
        if (readAccount(accountId).isPresent()) {
            try (Connection connection = ConnectionManager.open()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(format("UPDATE Accounts SET balance = " + (readAccount(accountId).get().getBalance() + amount) +
                        " WHERE accountId = %d", accountId));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("There is no account with this ID");
        }
    }

    /**
     * Reads account information
     *
     * @param accountId Id for which data should be read
     * @return account data
     */
    public static Optional<Account> readAccount(int accountId) {
        Account account = null;
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    format("SELECT * FROM Accounts WHERE accountId = %d", accountId));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getInt("userId"), resultSet.getDouble("balance"),
                        resultSet.getString("currency"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(account);
    }

    /**
     * Returns a list of the currencies of one user's accounts
     *
     * @param userId User ID
     * @return List currencies
     */
    public static List<String> getExistingAccountsCurrencies(int userId) {
        List<String> currencyList = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    format("SELECT currency FROM Accounts WHERE userId = %d", userId));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                currencyList.add(resultSet.getString("currency"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currencyList;
    }

    /**
     * Read all accounts from database
     */
    public static List<Account> readAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        Account account = null;
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    format("SELECT * FROM Accounts"));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getInt("userId"), resultSet.getDouble("balance"),
                        resultSet.getString("currency"));
                account.setAccountId(resultSet.getInt("accountId"));
                accountList.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }
}
