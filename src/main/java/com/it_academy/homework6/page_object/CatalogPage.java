package com.it_academy.homework6.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends BasePage {

    private static final By CATALOG_NAVIGATION_CLASSIFIER_ITEM = By.xpath(
            "//li[@class='catalog-navigation-classifier__item ']");
    private static final By COMPUTERS_AND_NETWORKS_LINK = By.xpath(
            "//li[@class='catalog-navigation-classifier__item ' and @data-id='2']");

    /**
     * Searches for horizontal tabs on "Каталог" page (e.g "Электроника", "Бытовая техника", "Компьютеры и сети" etc.)
     *
     * @return list of web elements
     */
    public List<WebElement> findCatalogNavigationClassifierItem() {
        return waitForElementVisible(CATALOG_NAVIGATION_CLASSIFIER_ITEM).findElements(CATALOG_NAVIGATION_CLASSIFIER_ITEM);
    }

    /**
     * Clicks on "Компьютеры и сети" tab
     *
     * @return "Компьютеры и сети" page
     */
    public ComputersAndNetworksPage clickOnComputersAndNetworksLink() {
        waitForElementVisible(COMPUTERS_AND_NETWORKS_LINK).click();
        return new ComputersAndNetworksPage();
    }
}
