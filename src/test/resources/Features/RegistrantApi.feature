Feature: create new registrants using api

  @API
  @APiRegistrant
  Scenario: create new users with api
    Given user sets the base url and path params
    And user sets the api data
    When user sends the request
    Then user validates user creation
    And user saves the api data


  @API
    @ApiGetRequest
  Scenario Outline: test created api users
    Given user provids path "<param1>" "<param2>"
    And user gets all api user info
    And user sends api Get request
    When user keeps all user api records
    Then user validates all api users
    Examples: api params
      |param1|param2|
      |api|tp-account-registrations|






