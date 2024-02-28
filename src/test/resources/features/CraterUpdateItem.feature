@test3 @regression

Feature: Update item functionality

Scenario: As a user, I am able to update an item or a service
Given As an entity user, I am logged in
And I navigate to Items tab
When I select the item "coffee mug"
And I should be on item details page
When I update the item price to 30 dollars
And I click Update Item button 
Then The Item price is updated to 30 dollars
And I delete the item
