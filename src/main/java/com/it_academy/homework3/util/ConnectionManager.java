package com.it_academy.homework3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "db.url";

    static {
        loadDriver();
    }

    private ConnectionManager() {
    }

    /**
     *Open a database connection
     *
     * @return Database connection
     */
    public static Connection open() {
        try {
            return DriverManager.getConnection(PropertiesUtil.get(DATABASE_URL));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

