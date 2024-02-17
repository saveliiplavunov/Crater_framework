
@test1 @regression
Feature: Crater Login Functionality


Scenario: Crater valid login
Given user is on the login page
When user entres a valid email and valid password
And user clicks on login button
Then user is logged in successfully

Scenario Outline: crater invalid login
Given user is on the login page
When user entres invalid "<email>" and "<password>"
And user clicks on login button
Then user should not be logged in


Examples: email/password
|  email          |  password   |
| omar@gmail.com  |  wrongPass  |
| wrong@gmail.com | dsadfsafsfs |
|                 |   dsadsaas  |
|                 |             |
