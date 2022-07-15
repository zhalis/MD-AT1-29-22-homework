package com.it_academy.homework6.page_object;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By CATALOG_LINK = By.xpath(
            "//*[@class='b-main-navigation__text' and text()='Каталог']");

    /**
     * Navigates to "Каталог" page
     *
     * @return "Каталог" page
     */
    public CatalogPage clickOnCatalogLink() {
        waitForElementVisible(CATALOG_LINK).click();
        return new CatalogPage();
    }
}
