package com.it_academy.homework3.demo;


import com.it_academy.homework3.dto.Account;
import com.it_academy.homework3.dto.User;
import com.it_academy.homework3.services.AccountService;
import com.it_academy.homework3.services.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL = System.getProperty("systemPropertyVariables");

    public static void main(String[] args)  {

        if (isDriverExists()) {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
                User user = new User("Smith Row", "Grodno");
                UserService.saveUser(user, connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("JDBC Driver not found");
            return false;
        }
    }
}
