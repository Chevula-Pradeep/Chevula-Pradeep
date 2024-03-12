@smokeTests
Feature: User is able to login Successfully to the saucedemo

  Scenario: User is able to login with valid credentials
    Given user is navigate to "https://www.saucedemo.com/v1/"
    And user is able to see and enter username is "standard_user"
    And user is able to see and enter password is "secret_sauce"
    #And user is able to see and enter valid "<p_username>" and "<p_password>"
    And user is able to click on Login button
    Then user is able to Navigate and see saucedemo page

   # Examples: | p_username    | p_password  |
   # | standard_user           | secret_sauce |
   # | locked_out_user         | secret_sauce |
    #| problem_user            | secret_sauce |
   # | performance_glitch_user | secret_sauce |

   