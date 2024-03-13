@smokeTests
Feature: User is able to login and do all tests in the saucedemo

  Scenario: User is able to login with valid credentials
    Given user is navigate to "https://www.saucedemo.com/v1/"
    And enter username "standard_user" and password "secret_sauce"
    And user is able to click on Login button
    Then user is able to Navigate and see saucedemo page

  Scenario: User is able to filter DropDown and checkout the Item
    Given user is to open DropDownTab
    And select the maximum price-product
    And select the product and verify price
    And select the add-to-cart webelement
    And user is able to see and verify that RedDotNumber
    Then user is able to remove the item from addto cart
