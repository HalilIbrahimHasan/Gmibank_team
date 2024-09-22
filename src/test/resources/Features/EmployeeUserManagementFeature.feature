@EmployeeUserManagement
Feature: employee user management activities

  Background: user navigation to manage customers page
    Given user navigates to lending page
    And user clicks on account menu
    And user clicks on sign in button
    When user provides login "tolgaqaengemployee"
    And user provides the  login "Stark2000+"
    Then user validates user login
    When user clicks and navigates to "My Operations"
    And user clicks and navigates to "Manage Customers"
    Then user validates customer management page

  @US009
    @US009_TC001
  Scenario Outline: user search for a new applicant by their SSN and see all their registration info
    Given user clicks create a new customer button
    When user enter search "<ssn>" number
    And user clicks send button
    And user checks registered ssn equality with search "<ssn>"
    And user clicks back button
    And user clicks on account menu
    Then user clicks on sign out button
    Examples:
      | ssn |
      | 116-24-3363 |

  @US010
    @US010_TC001
  Scenario Outline: address of customer can be created
    Given user clicks create a new customer button
    When user enter search "<ssn>" number
    And user clicks send button
    And user enters address information
    And user enters city information
    And user enters country information
    And user enters state information
    And user clicks back button
    And user clicks on account menu
    Then user clicks on sign out button

    Examples:
      | ssn |
      | 116-24-3363 |


  @US012
    @US012_TC001
  Scenario: customer module should show up the account information for all customers
    Given user checks all customer information














