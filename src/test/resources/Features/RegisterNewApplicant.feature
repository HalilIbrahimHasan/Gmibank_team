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
      |746-99-37-8594|okumus|xxxx|mad way|757-372-4637|ufukokumus|hello@gmail.com|Ufukok82|Ufukok82|


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

  @US_000003
  @TC_000008
  Scenario Outline: user checks password strength
    Given user navigates to registration page
    And user provides a "<password>" with at least seven chars as lowercase
    And user provides a "<password2>" with seven c  + upper case
    And user provides a "<password3>" with seven c + up c  & num
    And user provides a "<password4>" with seven c + up c  num & special char
    Examples: password data validation
    |password|password2|password3|password4|
    |asdfghj |asdfhjU  |asdfgU7  |asdfU6!  |


    @US_000003
   @TC_000009
  Scenario Outline: user checks password strength 2. coverage
    Given user navigates to registration page
    And user provides a "<password>"
    Then user validates "<sLevel>"

    Examples: password strength data validation
    |password|sLevel|
    |asdfghj |1     |
    |asdfhjU |2     |
    |asdfgU7 |3     |
    |asdfU6! |4     |



