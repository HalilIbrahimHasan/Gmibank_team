Feature: test customer management

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
        |Description|checking account talentify1|Balance|200000000|CHECKING|ACTIVE|gmiBankBackendApp|
        |Description|saving account talentify1|Balance|200000000|SAVING|ACTIVE|gmiBankBackendApp|


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