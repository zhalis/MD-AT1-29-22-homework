package com.it_academy.homework7.hooks;

import com.it_academy.homework7.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quidDriver();
    }
}

