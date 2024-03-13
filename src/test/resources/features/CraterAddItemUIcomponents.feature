@regression
Feature: Veirify add item UI components

Background:  
Given I am an external user of the Prime Tech Invoice Application
And I have logged in to the application
And I click on the Items Menu Link

@UIItems @regression
Scenario: Add Items Page UI components
Then I should be navigated to a page titled Items
And I should see the menu navigation path as Home Items placed under Items
And I should see a secondary button titled Filter with a filter icon
And I should see a primary button titled + Add Item
Then I should see a table with the following columns
And Seclect All checkbox.NAME.UNIT.PRICE.ADDED ON
And Link icon showing three dots with the following options:
And Link with an edit icon.
And Delete with a delete icon.
And Pagination text as follows: Showing total items results
When user click on the right arrow 
Then user should be navigated to next page
When user click on the left arrow
Then user should be naviagated to previous page
When user is on the first page
Then left arrow should be disabled
When user is on the last page 
Then right arrow should be disabled

@AddItemUI @regression
Scenario: Add a Item UI components - New Item
When I click on +Add Item
Then I Should be directed tot the create Item page
And I shoud see the page title New Item
And The patyh underneath the title should be Home/Items/New Item
And a textbox labeled Name
And a textbox labled Price
And a dropdown labled unit
And a comment box labled Description
And a primary button labeled Save Item








