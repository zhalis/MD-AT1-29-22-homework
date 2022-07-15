package com.it_academy.homework6;

import com.it_academy.homework6.navigation.OnlinerNavigation;
import com.it_academy.homework6.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.util.StringUtils.isNotBlank;

public class ProductPageNavigationTest {

    public static final String CATALOG_NAVIGATION_LIST_DROPDOWN_ACCESSORIES_TITLE =
            "catalog-navigation-list__dropdown-title";
    public static final String CATALOG_NAVIGATION_LIST_DROPDOWN_ACCESSORIES_DESCRIPTION =
            "catalog-navigation-list__dropdown-description";

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис"})
    public void testThePresenceOfSectionsInTheCatalogSection(String category) {
        Boolean isPageContainsSectionName = new HomePage().clickOnCatalogLink()
                .findCatalogNavigationClassifierItem()
                .stream()
                .map(WebElement::getText)
                .anyMatch(category::equals);
        assertThat(isPageContainsSectionName).as("This Web element is missing").isTrue();
    }

    @Test
    public void testWebElementIsNotPresentInCatalogSection() {
        String category = "Еда";
        Boolean isPageContainsSectionName = new HomePage()
                .clickOnCatalogLink()
                .findCatalogNavigationClassifierItem()
                .stream()
                .map(WebElement::getText)
                .anyMatch(category::equals);
        assertThat(isPageContainsSectionName).as("This Web element is not present").isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных",
            "Мультимедиа периферия", "Сетевое оборудование", "Электропитание"})
    public void testOpenSectionOfTheCatalogComputersAndNetworksAndCheckingTheVerticalList(String category) {
        Boolean element = new HomePage()
                .clickOnCatalogLink()
                .clickOnComputersAndNetworksLink()
                .findWebElementCatalogNavigationList(category)
                .isDisplayed();
        assertThat(element).as("This Web element is missing").isTrue();
    }

    @Test
    public void testEveryElementOnAccessoriesInComputersAndNetworksTabHasTitle() {
        assertTrue(new HomePage()
                        .clickOnCatalogLink()
                        .clickOnComputersAndNetworksLink()
                        .clickOnAccessoriesLink()
                        .findDropdownAccessoriesList()
                        .stream()
                        .allMatch(webElement -> isNotBlank(getWebElementTitle(webElement))),
                "Not all web elements contain a title");
    }

    @Test
    public void testEveryElementOnAccessoriesInComputersAndNetworksTabHasAmountOfItems() {
        assertTrue(new HomePage()
                        .clickOnCatalogLink()
                        .clickOnComputersAndNetworksLink()
                        .clickOnAccessoriesLink()
                        .findDropdownAccessoriesList()
                        .stream()
                        .allMatch(webElement -> getWebElementDescription(webElement).contains("товар")),
                "Not all web elements contain an amount of items");
    }

    @Test
    public void testEveryElementOnAccessoriesInComputersAndNetworksTabHasMinimalPrice() {
        assertTrue(new HomePage()
                        .clickOnCatalogLink()
                        .clickOnComputersAndNetworksLink()
                        .clickOnAccessoriesLink()
                        .findDropdownAccessoriesList()
                        .stream()
                        .allMatch(webElement -> getWebElementDescription(webElement).contains("от")),
                "Not all web elements contain a minimal price");
    }

    @AfterAll
    public static void close() {
        new HomePage().closeBrowser();
    }

    private String getWebElementTitle(WebElement webElement) {
        return webElement.findElement(By.className(CATALOG_NAVIGATION_LIST_DROPDOWN_ACCESSORIES_TITLE)).getText();
    }

    private String getWebElementDescription(WebElement webElement) {
        return webElement.findElement(By.className(CATALOG_NAVIGATION_LIST_DROPDOWN_ACCESSORIES_DESCRIPTION)).getText();
    }
}
