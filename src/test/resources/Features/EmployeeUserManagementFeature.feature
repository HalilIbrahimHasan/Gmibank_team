@EmployeeUserManagement
Feature: employee user management activities

  Background: user navigation
    Given user navigates to lending page

  Scenario Outline: login with valid credentials
    Given user clicks on account menu
    And user clicks on sign in button
    When user provides login "<username>"
    And user provides the  login "<password>"
    Then user validates user login

    Examples: login test data
      |username|password|
      |tolgaqaengemployee |Stark2000+|

  Scenario Outline: navigate to customer management page
    Given user clicks and navigates to "My Operations"
    And user clicks and navigates to "Manage Customers"
    Then user validates customer management page
