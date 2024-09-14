 Feature: Register new users for GMI bank

   Background: go lending page
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
         |473-99-37-8594|talent|lab|hello way|362-372-4637|talentlab|tale@gmail.com|Talen1234!|Talen1234!|
         |473-99-37-8594|talent|lab|hello way|362-372-4637|talentlab|tale@gmail.com|Talen1234!|Talen1234!|
         |473-99-37-8594|talent|lab|hello way|362-372-4637|talentlab|tale@gmail.com|Talen1234!|Talen1234!|
         |473-99-37-8594|talent|lab|hello way|362-372-4637|talentlab|tale@gmail.com|Talen1234!|Talen1234!|






