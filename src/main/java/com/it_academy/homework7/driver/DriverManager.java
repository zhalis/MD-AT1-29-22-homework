package com.it_academy.homework7.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private static final String CHROME_DRIVE_PATH = "src/test/resources/chromedriver.exe";
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public DriverManager() {
    }

    public static void setupDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVE_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
        webDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quidDriver() {
        Optional.ofNullable(getDriver()).ifPresent(WebDriver::quit);
    }
}
