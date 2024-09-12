
Feature: login functionality test


  Background: user navigation
    Given user navigates to lending page

  @login
  Scenario Outline: test login function

    And user provides "<username>" and "<password>"
    Then user validates user login

    Examples: login credentials
      |username|password|
      |CWoburn |Cw192837?|


  @US_000004
    @TC_000005
  Scenario Outline: login with valid credentials
    Given user clicks on account menu
    And user clicks on sign in button
    When user provides login "<username>"
    And user provides the  login "<password>"
    Then user validates user login

    Examples: login test data
      |username|password|
      |CWoburn |Cw192837?|

  @US_000004
  @TC_000006
  Scenario: test case 000006 cancel options
    Given user clicks on account menu
    And user clicks on sign in button
    When user clicks on cancel button
    Then user validates the cancellation


  @US_000004
    @TC_000007
  Scenario Outline: cancel with credentials
    Given user clicks on account menu
    And user clicks on sign in button
    When user provides login "<username>"
    And user provides the  login "<password>"
    When user clicks on cancel button
    Then user validates the cancellation

    Examples: login test data
      |username|password|
      |CWoburn |Cw192837?|
