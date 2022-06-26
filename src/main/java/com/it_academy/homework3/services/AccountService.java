package com.it_academy.homework3.services;

import com.it_academy.homework3.dto.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class AccountService {

    public static void saveAccount(Account account, Connection connection) {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(format("INSERT INTO Accounts (userId, balance, currency) VALUES(%d, %d, %s)",
                    account.getUserId(), account.getBalance(), account.getCurrency()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateAccount(Account account, Connection connection, int id)  {
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(format("UPDATE Accounts SET (balance) WHERE (accountId) VALUES(%d, %d)",
                    account.getBalance(), id));
        }catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
