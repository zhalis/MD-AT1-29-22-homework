package com.it_academy.homework3.services;

import com.it_academy.homework3.dto.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class UserService {

    public static void saveUser(User user, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(format("INSERT INTO Users (name, address) VALUES('%s', '%s')",
                    user.getName(), user.getAddress()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
