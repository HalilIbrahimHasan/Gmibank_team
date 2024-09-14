@EndToEndTest
Feature: user management activities

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
      |CWoburn |Cw192837?|

