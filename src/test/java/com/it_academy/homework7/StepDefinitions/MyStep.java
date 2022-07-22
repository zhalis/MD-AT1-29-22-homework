package com.it_academy.homework7.StepDefinitions;

import com.it_academy.homework7.page_object.CarFleaMarketPage;
import com.it_academy.homework7.page_object.HomePage;
import com.it_academy.homework7.page_object.HouseAndApartmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyStep {
    private final HomePage homePage = new HomePage();

    private final CarFleaMarketPage carFleaMarketPage = new CarFleaMarketPage();

    private final HouseAndApartmentPage houseAndApartmentPage = new HouseAndApartmentPage();

    @Given("the user open Onliner website")
    public void theUserOpenOnlinerWebsite() {
        homePage.openOnlinerWebsite();
    }

    @When("the user hovers over the car flea market section")
    public void theUserHoversOverTheCarFleaMarketSection() {
        homePage.hoverOnCarFleaMarketLink();
    }

    @Then("check  if there is a {string} division")
    public void checkIfThereIsAPriceDivision(List<String> price) {
        assertTrue(carFleaMarketPage.webElementPrice()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(price), "");
    }

    @And("check if there is a division by {string}")
    public void checkIfThereIsADivisionByCity(List<String> city) {
        assertTrue(carFleaMarketPage.webElementCity()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(city));
    }

    @And("check if there is division by {string}")
    public void checkIfThereIsDivisionByBrand(List<String> brand) {
        assertTrue(carFleaMarketPage.webElementBrands()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(brand), "");
    }

    @When("the user hovers over the house and rooms section")
    public void theUserHoversOverTheHouseAndRoomsSection() {
        homePage.hoverOnHouseAndApartmentLink();
    }


    @Then("check on house and rooms section if there is a {string} division")
    public void checkOnHouseAndRoomsSectionIfThereIsAPriceRangeDivision(List<String> price) {
        assertTrue(houseAndApartmentPage.webElementPrice()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(price), "");
    }

    @And("check on house and rooms section if there is a division by {string}")
    public void checkOnHouseAndRoomsSectionIfThereIsADivisionByCity(List<String> city) {
        assertTrue(houseAndApartmentPage.webElementCity()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(city), "");
    }

    @And("check that the house and apartment submenu displays the {string}")
    public void checkThatTheHouseAndApartmentSubmenuDisplaysTheNumberOfRooms(List<String> numberOfRooms) {
        assertTrue(houseAndApartmentPage.webElementNumbersOfRoomss()
                .stream()
                .map(WebElement::getText).toList()
                .containsAll(numberOfRooms), "");
    }
}
