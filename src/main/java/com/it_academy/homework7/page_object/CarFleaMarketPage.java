package com.it_academy.homework7.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarFleaMarketPage extends BasePage {

    private static final By DROPDOWN_LIST_PRICE_ON_CAR_FLEA_MARKET_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[3]/div[1]/div[1]/div[1]" +
                    "/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]");

    private static final By DROPDOWN_LIST_CITY_ON_CAR_FLEA_MARKET_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[3]/div[1]/div[1]/div[1]" +
                    "/div[1]/div[1]/div[2]/div[1]/div[1]/ul[2]");

    private static final By DROPDOWN_LIST_BRAND_ON_CAR_FLEA_MARKET_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[3]/div[1]/div[1]" +
                    "/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[3]");

    public List<WebElement> webElementPrice() {
        return findElements(DROPDOWN_LIST_PRICE_ON_CAR_FLEA_MARKET_SECTION);
    }

    public List<WebElement> webElementCity() {
        return findElements(DROPDOWN_LIST_CITY_ON_CAR_FLEA_MARKET_SECTION);
    }

    public List<WebElement> webElementBrands() {
        return findElements(DROPDOWN_LIST_BRAND_ON_CAR_FLEA_MARKET_SECTION);
    }
}
