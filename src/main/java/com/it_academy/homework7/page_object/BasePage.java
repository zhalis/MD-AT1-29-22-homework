package com.it_academy.homework7.page_object;

import com.it_academy.homework7.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    private static final int TIME_OF_WAIT_FOR_ELEMENT_VISIBLE = 60;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), TIME_OF_WAIT_FOR_ELEMENT_VISIBLE);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }
}
