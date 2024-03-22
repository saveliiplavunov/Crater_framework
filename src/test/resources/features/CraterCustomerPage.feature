 @CustomersUI
Feature: Verify crater customer page

Background:
Given I am an external user of the Prime Tech Invoice Application
And I have logged in to the application 
When I click on the Customers Menu Link
@CustomersUI
Scenario: Add Customer Page UI components
Then I should be navigated to a page titled Customers
And I should see the menu navigation path as Home customers placed under Customers
And I should see a secondary button titled Filter with a filter icon
And I should see a primary button titled +New customer
Then I should see a table with the following colums: Select all checkbox, name, phone, amount due, added on
And A link showing tree dots with following options: Edit with and edit icon, View with view icon, delete with a delete icon
Then I should see pagination text as follows: Showing one to ten total customers reusult
And Panigation navigation with following controls: left arrow, right arrow, number indicating page
When Left arrow disabled
Then User on the first page
When Right arrow disabled
Then User on the last page
