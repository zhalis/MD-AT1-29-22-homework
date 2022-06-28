package com.it_academy.homework3.dao;

import com.it_academy.homework3.entity.User;
import com.it_academy.homework3.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class UserDao {

    /**
     * Saves the user to the database
     *
     * @param user User to be added to the database
     */
    public static void saveUser(User user) {
        try (Connection connection = ConnectionManager.open()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Users (name, address) VALUES('%s', '%s')",
                    user.getName(), user.getAddress()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read all Users from database
     */
    public static List<User> readAllUsers() {
        List<User> userList = new ArrayList<>();
        User user = null;
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(
                    format("SELECT * FROM Users"));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getString("name"), resultSet.getString("address"));
                user.setUserId(resultSet.getInt("userId"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
