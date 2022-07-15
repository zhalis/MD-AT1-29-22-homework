package com.it_academy.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverDiscovery {

    private static final int DURATION_OF_WAITING_FOR_OPENING_BROWSER = 15;
    private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<>();

    public WebDriverDiscovery() {
        if (remoteWebDriver.get() == null) {
            startBrowser();
        }
    }

    private void startBrowser() {
        setWebDriver(new ChromeDriver());
    }

    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DURATION_OF_WAITING_FOR_OPENING_BROWSER, TimeUnit.SECONDS);
    }

    /**
     * Gets web driver
     *
     * @return web driver
     */
    public WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }
}
