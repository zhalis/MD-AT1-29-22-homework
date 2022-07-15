package com.it_academy.homework6.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ComputersAndNetworksPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//div[contains(text(),'%s')]";
    private static final String ACCESSORIES = "Комплектующие";

    /**
     * Searches for vertical category on "Компьютеры и сети" page by name
     *
     * @param category category name
     * @return web element matching category
     */
    public WebElement findWebElementCatalogNavigationList(String category) {
        return waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category)))
                .findElement(By.xpath(format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, category)));
    }

    /**
     * Clicks on "Комплектующие" tab on "Компьютеры и сети" page
     *
     * @return accessories from "Комплектующие" tab
     */
    public Accessories clickOnAccessoriesLink() {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, ACCESSORIES))).click();
        return new Accessories();
    }
}
