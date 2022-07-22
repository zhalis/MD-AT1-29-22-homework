package com.it_academy.homework7.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HouseAndApartmentPage extends BasePage {

    private static final By DROPDOWN_LIST_PRICE_ON_HOUSE_AND_APARTMENT_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[4]" +
                    "/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");

    private static final By DROPDOWN_LIST_CITY_ON_OUSE_AND_APARTMENT_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[4]" +
                    "/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]");

    private static final By DROPDOWN_LIST_NUMBER_OF_ROOMS_ON_OUSE_AND_APARTMENT_SECTION =
            By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[4]" +
                    "/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]");

    public List<WebElement> webElementPrice() {
        return findElements(DROPDOWN_LIST_PRICE_ON_HOUSE_AND_APARTMENT_SECTION);
    }

    public List<WebElement> webElementCity() {
        return findElements(DROPDOWN_LIST_CITY_ON_OUSE_AND_APARTMENT_SECTION);
    }

    public List<WebElement> webElementNumbersOfRoomss() {
        return findElements(DROPDOWN_LIST_NUMBER_OF_ROOMS_ON_OUSE_AND_APARTMENT_SECTION);
    }
}
