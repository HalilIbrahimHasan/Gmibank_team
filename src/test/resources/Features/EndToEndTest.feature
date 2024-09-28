
@EndToEndTest
Feature: test all users


  Background: user navigation
    Given user navigates to lending page

  @NewRegistrants
  Scenario Outline: register new users for GMI bank app
    Given user navigates to dropdown menu
    And user clicks on "Register"
    And user provides "<ssn>" number
    And user provides "<firstname>"
    When user provides "<lastname>" of user
    Then user provides "<address>" info
    And user provides mobile "<phone>" number
    And user provides unique "<username>"
    And user gives a valid "<email>" id
    When user sends "<password>"
    Then user provides same "<passwordCon>"
    And user valides applicant registration
    Then user saves the applicant info

    Examples: User registration data
      |ssn|firstname|lastname|address|phone|username|email|password|passwordCon|
      |473-99-37-8594|talent|lab|hello way|362-372-4637|talentlab|tale@gmail.com|Talen1234!|Talen1234!|

  Scenario Outline: login with valid credentials
    Given user clicks on account menu
    And user clicks on sign in button
    When user provides login "<username>"
    And user provides the  login "<password>"
    Then user validates user login

    Examples: login test data
      |username|password|
      |CWoburn |Cw192837?|


  @userMan2
  Scenario Outline: activate a user role
    Given user clicks and navigates to "Administration"
    And user clicks and navigates to "User management"
    When user gets to last page of pagination
    And user navigates to current user actions
    Then user assigns the user "<role>"
    And user clicks on "Save"
    And user refreshes the page
    When user gets to last page of pagination
    Then user activates the current role
    Then user logs out

    Examples: find and activate user data
      |role|
      |ROLE_Customer|

  Scenario Outline: login with valid credentials
    Given user clicks on account menu
    And user clicks on sign in button
    When user provides login "<username>"
    And user provides the  login "<password>"
    Then user validates user login

    Examples: login test data
      |username|password|
      |AlyshaHills|As!p*^50%5rB0qome|

  @accountManagement
  Scenario Outline: create new accounts
    Given user clicks on "My Operations"
    And user clicks on "Manage Accounts"
    Then user clicks on "Create a new Account"
    And user gives "<header>" and "<input>"
    When user selects "<account>"
    And user chooses "<status>"
    And user gives "<balance>" and "<amount>"
    And user clicks on "Save"
    Then validate toast "<message>"

    Examples: test data for accounts
      |header|input|balance|amount|account|status|message|
      |Description|checking account talentify5|Balance|200000000|CHECKING|ACTIVE|gmiBankBackendApp|
      |Description|saving account talentify5|Balance|200000000|SAVING|ACTIVE|gmiBankBackendApp|


  @customerManagement
  Scenario Outline: create new accounts
    Given user clicks on "My Operations"
    And user clicks on "Manage Customers"
    Then user clicks on "Create a new Customer"
    And user searches customer by "<ssn>"
    Then user clicks on "Search"
    Then user clicks on "Save"
    When user gives "<mid>" and "<char>"
    Then user provides the user "<email>" again
    And user provides "<phone>" again
    And user gives "<zip>" and "<value>"
    And user gives "<city>" and "<name>"
    Then user selects accounts
    And user clicks on "Save"

    Examples: customer data
      |ssn|mid|char|email|phone|zip|value|city|name|
      |SSN|Middle Initial|S|Email|Phone Number|Zip Code|30006|City|Istanbul|