Feature: generate new applicants



  Background: user navigation
    Given user navigates to lending page



    @newApplicant
    Scenario Outline: generate new users for GMI
      Given user navigates to registration page
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
      |463-37-8594|Arya|Stark|maden way|463-372-4637|gmiusers|hellolowy@gmail.com|Stark2000+|Stark2000+|



   @US_0001
     @TC_00001
  Scenario Outline: user wıth valıd ssn should have no error message
    Given user navigates to registration page
    And user provides "<ssn>" number
    Then user validates ssn
    Examples: test data
    |ssn|
    |362-37-3736|

  @US_0002
    @TC_00002
  Scenario Outline: user wıth invalıd ssn should have error message
    Given user navigates to registration page
    And user provides "<ssn>" number
    Then user validates  invalid ssn
    Examples: test data
      |ssn|
      |362-37-3|