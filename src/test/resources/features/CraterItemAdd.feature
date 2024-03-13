@regression
Feature: Add Item Functionality

@test2 @regression
Scenario: As a user, I am able to create an item or a service
Given As an entity user, I am logged in
And I navigate to Items tab
When I click on the Add Item button
Then I should be on item input page
When I provide item information name "itemName", price "1800.00", unit "pc", and description "a good book"
And I click Save Item button 
Then The Item is added to the Item list table
And I delete the item

@AddItemValidation @regression
Scenario: As a user,I should not be able to create an item with invalid data
Given As an entity user, I am logged in
And I navigate to Items tab
When I click on the Add Item button
And User leaving Name input box blank
Then user should see an error message Item Name Required 
And User input more then fifty chararcters into Name input box
Then user should see an error message Item Name Incorrect
And User inputs more then two hundred characters into the description field
Then User should see an error message "Description must be 200 characters or less"

@FilteringItemdata @regression
Scenario: As a user,I should be able to filter the data on the Item Table
Given I am an external user of the Prime Tech Invoice Application
And I have logged in to the application
And I click on the Items Menu Link
When I click on Filter Icon
Then I should see the following text boxes appear as a name, unit, price, clear all
When I type value in the name text box
Then Application will perform a wild card search for any item matching the value
When I type value in the Unit text box
Then Application will perform a wild card search for any item matching the value
When I type a value in the Price text box
Then Application will perform a wild card search for any item matching the value
When I type a value in one or more of the text boxes
Then Application will perform a wild card search based on a item matching all combinations
When my search does not return any results 
Then I should see an empty table with the following message in grey "No result Found"
When I click on the Clear All link
Then Application will display the current list of items
When I click on the Filter button again
Then I should see the dialog closed










 
 
 