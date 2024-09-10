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
     @TC_0001
  Scenario Outline: user with valid ssn should have no error message
    Given user navigates to registration page
    And user provides "<ssn>" number
    Then user validates ssn
    Examples: test data
    |ssn|
    |362-37-3736|

  @US_0001
    @TC_0002
  Scenario Outline: user with valid first name should have no error message
    Given user navigates to registration page
    And user provides "<firstname>"
    Then user validates first name
    Examples: test data
      |firstname|
      |Abcdef|

  @US_0001
    @TC_0003
  Scenario Outline: user with valid last name should have no error message
    Given user navigates to registration page
    When user provides "<lastname>" of user
    Then user validates last name
    Examples: test data
      |lastname|
      |Abcdef|

  @US_0001
    @TC_0004
  Scenario Outline: user with valid address should have no error message
    Given user navigates to registration page
    Then user provides "<address>" info
    Then user validates address
    Examples: test data
      |address|
      |Abcdef Ghij|

  @US_0001
    @TC_0005
  Scenario Outline: user with valid mobile phone should have no error message
    Given user navigates to registration page
    And user provides mobile "<phone>" number
    Then user validates mobile phone
    Examples: test data
      |phone|
      |555-555-5555|

  @US_0001
    @TC_0006
  Scenario Outline: user with valid username should have no error message
    Given user navigates to registration page
    And user provides unique "<username>"
    Then user validates username
    Examples: test data
      |username|
      |Qwerty|

  @US_0001
    @TC_0007
  Scenario Outline: user with valid email should have no error message
    Given user navigates to registration page
    And user gives a valid "<email>" id
    Then user validates email
    Examples: test data
      |email|
      |qq@qq.com|






  @US_0002
    @TC_0002
  Scenario Outline: user wıth invalıd ssn should have error message
    Given user navigates to registration page
    And user provides "<ssn>" number
    Then user validates  invalid ssn
    Examples: test data
      |ssn|
      |362-37-3|