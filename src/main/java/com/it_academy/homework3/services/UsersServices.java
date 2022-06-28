package com.it_academy.homework3.services;

import com.it_academy.homework3.dao.UserDao;
import com.it_academy.homework3.entity.User;

import java.util.List;

public class UsersServices {

    /**
     * Saves the user to the database
     *
     * @param user User to be added to the database
     */
    public static void saveUser(User user) {
        UserDao.saveUser(user);
    }

    /**
     * Read all Users from database
     */
    public static List<User> readAllUsers() {
        return UserDao.readAllUsers();
    }
}

