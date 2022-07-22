package com.it_academy.homework7.page_object;

import com.it_academy.homework7.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {


    private static final String ONLINER_URL = "https://www.onliner.by/";

    private static final By NAVIGATION_TO_CAR_FLEA_MARKET_LINK =
            By.xpath("//ul[@class='b-main-navigation']/li[3]");

    private static final By NAVIGATION_TO_HOUSE_AND_APARTMENT_LINK =
            By.xpath("//ul[@class='b-main-navigation']/li[4]");

    public HomePage() {
    }

    public void openOnlinerWebsite() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

    public CarFleaMarketPage hoverOnCarFleaMarketLink() {
        Actions actions = new Actions(DriverManager.getDriver());
        WebElement toCarFleaMarketLink = findElement(NAVIGATION_TO_CAR_FLEA_MARKET_LINK);
        actions.moveToElement(toCarFleaMarketLink).build().perform();
        return new CarFleaMarketPage();
    }

    public HouseAndApartmentPage hoverOnHouseAndApartmentLink() {
        Actions actions = new Actions(DriverManager.getDriver());
        WebElement toCarFleaMarketLink = findElement(NAVIGATION_TO_HOUSE_AND_APARTMENT_LINK);
        actions.moveToElement(toCarFleaMarketLink).build().perform();
        return new HouseAndApartmentPage();
    }
}
