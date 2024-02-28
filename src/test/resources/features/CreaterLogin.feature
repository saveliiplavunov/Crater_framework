
@test1 @regression
Feature: Crater Login Page Functionality


Scenario: Prime Tech Invoice App Login UI Components
Given user is on the login page
When user is on the login page
Then user should be able so see Page Title "crater",textbox with label "Email",textbox with label "Password",link title "Forgot password",primary button "Login",text area "Copyright @ Crater Invoice, Inc. 2023",heading "Simple Invoicing for Individuals Small Businesses",and second heading "Crater helps you track expenses, record payments & generate beautiful invoices & estimates"


Scenario: Crater valid login
Given user is on the login page
When user entres a valid email and valid password
And user clicks on login button
Then user is logged in successfully

Scenario Outline: crater invalid login
Given user is on the login page
When user entres invalid "email>" and "<password>"
And user clicks on login button
Then user should not be logged in


Examples: email/password
|  email          |  password   |
| ong@gmail.com   |  wrongPass  |
| wrong@gmail.com | dsadfsafsfs |
|                 |   dsadsaas  |
|                 |             |
