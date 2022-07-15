package com.it_academy.homework6.page_object;

import com.it_academy.homework6.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private static final int TIME_OF_WAIT_FOR_ELEMENT_VISIBLE = 60;
    private final WebDriver driver;

    public BasePage() {
        WebDriverDiscovery webDriverDiscovery = new WebDriverDiscovery();
        this.driver = webDriverDiscovery.getWebDriver();
    }

    /**
     * Waits 60 sec for web element to load by {@link By}
     *
     * @param by locator
     * @return web element
     */
    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, TIME_OF_WAIT_FOR_ELEMENT_VISIBLE);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Navigates to web page by provided URL
     *
     * @param url URL to web page
     */
    public void navigate(String url) {
        this.driver.get(url);
    }

    /**
     * Closes browser
     */
    public void closeBrowser() {
        this.driver.quit();
    }
}
