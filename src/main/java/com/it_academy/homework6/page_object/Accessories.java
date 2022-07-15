package com.it_academy.homework6.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Accessories extends BasePage {

    private static final By CATALOG_NAVIGATION_DROPDOWN_ACCESSORIES_LIST = By.xpath(
            "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']/div[2]");

    /**
     * Searches for web elements on "Компьютеры и сети" -> "Комплектующие" tab
     *
     * @return list of web elements
     */
    public List<WebElement> findDropdownAccessoriesList() {
        return waitForElementVisible(CATALOG_NAVIGATION_DROPDOWN_ACCESSORIES_LIST)
                .findElements(CATALOG_NAVIGATION_DROPDOWN_ACCESSORIES_LIST);
    }
}
