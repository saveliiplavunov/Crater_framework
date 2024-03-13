

Feature: Update item functionality


@test3 @regression
Scenario: As a user, I am able to update an item or a service
Given As an entity user I am logged in
And I navigate to Items tab
When I select the item 
And I should be on item details page
When I update the item price to 30 dollars
And I click Update Item button 
Then The Item price is updated to 30 dollars
And I delete the item

@DeleteAllItems @regression
Scenario: As a user,I am able to delte item
Given As an entity user I am logged in
And I navigate to Items tab
When click on the Select ALL checkbox in the Items Table OR check multiple rows
And I click on the Actions dropdown
And I click on Delete
Then I should see a alert icon Are you sure
And I should see a message You will not be able to recover these items
And I click OK button
Then I should see a flash message Success Items deleted successfully with a close button to the right
Then User I should be directed to the items table


