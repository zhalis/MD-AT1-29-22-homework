Feature: As a user I want to check if the Auto Flea Market item contains categories division by prices by cities and brands

  Scenario Outline: The car flea market section contains the price of the city and brands
    Given the user open Onliner website
    When the user hovers over the car flea market section
    Then check  if there is a 'Price' division
    Examples:
      | Авто до 4000 р.  |
      | Авто до 10000 р. |
    And check if there is a division by 'City'
    Examples:
      | Минск   |
      | Гомель  |
      | Брест   |
      | Гродно  |
      | Витебск |
      | Могилев |
    And check if there is division by 'Brand'
    Examples:
      | Audi    |
      | BMW     |
      | Citroen |
      | Ford    |
      | Mazda   |

  Scenario Outline: The house and apartment section contains the price of the city and number of rooms
    Given the user open Onliner website
    When the user hovers over the house and rooms section
    Then check on house and rooms section if there is a 'Price range' division
    Examples:
      | до 30000$    |
      | 30000-80000$ |
      | от 80000$    |
    And check on house and rooms section if there is a division by 'City'
    Examples:
      | Минск   |
      | Гомель  |
      | Брест   |
      | Гродно  |
      | Витебск |
      | Могилев |
    And check that the house and apartment submenu displays the 'Number of rooms'
    Examples:
      | 1-комнатная |
      | 2-комнатная |
      | 3-комнатная |
      | 4-комнатная |