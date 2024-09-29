Feature: country api test


  Background: set the base url
    Given user sets the base url for all apis


   @API
    Scenario Outline: test country api
      Given user sets path params
      |param1|param2|
      |api|tp-countries|
      And user sets the data "<idJson>" and "<name>"
      When user sends POST request
      Then user validates country

      Examples: country data
      |idJson|name|
      |name  |ObjectMapper|



  @API
  Scenario Outline: update country
    Given user sets path params
      |param1|param2|
      |api|tp-countries|
    And user sets the data for "<id>" and "<name>"
    When user sends PUT request
    Then user validates updated country

    Examples: country data
      |id|name|
      |197833|FunClub|




  @API
  Scenario: delete country
    Given user sends request with three params
      |param1|param2|param3|
      |api|tp-countries|197824|
    When user sends Delete request
    Then user validates deleted country


  @API
  Scenario: get country data
    Given user sends request with three params
      |param1|param2|param3|
      |api|tp-countries|197833|
    When user sends get request
    Then user validates country data


