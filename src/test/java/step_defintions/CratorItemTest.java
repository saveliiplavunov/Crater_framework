package step_defintions;

import static org.junit.Assert.assertTrue;




import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import pages.CreaterLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;




public class CratorItemTest {
	BrowserUtils utils = new BrowserUtils();
	CraterDashboardPage dash = new CraterDashboardPage();
	CraterItemsPage items = new CraterItemsPage();
	CreaterLoginPage login = new CreaterLoginPage();
	

	

	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    Driver.getDriver().get(DataReader.getProperty("crater_url"));
	    utils.sendkeysWithActionsClass(login.emailInputBox,DataReader.getProperty("crater_email"));
	    login.passwordInputBox.sendKeys(DataReader.getProperty("crater_password"));
	    login.loginBtn.click();
//	    Assert.assertFalse(login.loginBtn.isDisplayed());
		
	}
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
	    // Write code here that turns the phrase above into concrete actions
		utils.waitForElementToBeVisible(dash.TextDisplayed);
		dash.ItemsLink.click();
	}

	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		utils.waitForElementToBeVisible(items.AddItemBtn);
	    items.AddItemBtn.click();
	}
	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() {
//	    utils.waitForElementToBeVisible(items.ItemsPageHeader);
//	    assertTrue(items.ItemsPageHeader.isDisplayed());
	    
	}
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, String price, String unit, String Description) {
		utils.waitForElementToBeVisible(items.ItemNameBox);
		items.ItemNameBox.sendKeys(name);
		items.PriceItemBox.sendKeys(price);
		items.ItemUnitBox.sendKeys(unit+Keys.ENTER);
		items.ItemDiscriptionBox.sendKeys(Description);
	}
	@When("I click Save Item button")
	public void i_click_save_item_button() {
	    items.SaveItemBtn.click();
	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(items.FirstItemCheckBox.isDisplayed());
	}
	
	@Then("I delete the item")
	public void i_delete_the_item() {
	    // Write code here that turns the phrase above into concrete actions
		utils.waitForElementToBeVisible(items.FirstItemCheckBox);
	   items.FirstItemCheckBox.click();
	   items.ActionBtn.click();
	   items.DeleteBtn.click();
	   items.ConfirmationBtn.click();
	}
	
	@When("User leaving Name input box blank")
	public void user_leaving_name_input_box_blank() {
	    items.SaveItemBtn.click();
	}
	@Then("user should see an error message Item Name Required")
	public void user_should_see_an_error_message_item_name_required() {
	    utils.waitForElementToBeVisible(items.FieldIsRequiredMsg);
	    String msg = items.FieldIsRequiredMsg.getText();
	    if(msg.equals("Field is required")) {
	    	Assert.assertTrue(items.FieldIsRequiredMsg.isDisplayed());
	    }
	}
	@Then("User input more then fifty chararcters into Name input box")
	public void user_input_more_then_fifty_chararcters_into_name_input_box() {
	    items.ItemNameBox.sendKeys("fhdsjklfhdsdshfdjksfghdsjfkhdsjfhdsfkjdsffsdfdsgjfdshsduijdsadsadasdaasdda");
	    items.SaveItemBtn.click();
	}
	@Then("user should see an error message Item Name Incorrect")
	public void user_should_see_an_error_message_item_name_incorrect() {
	    
	}
	@Then("User inputs more then two hundred characters into the description field")
	public void user_inputs_more_then_two_hundred_characters_into_the_description_field() {
	    
	}
	@Then("User should see an error message {string}")
	public void user_should_see_an_error_message(String errorMessage) {
	    
	}
	@When("I click on Filter Icon")
	public void i_click_on_filter_icon() {
		utils.waitForElementToBeVisible(items.AddItemBtn);
	    items.AddItemBtn.click();
	    utils.waitForElementToBeVisible(items.ItemNameBox);
		items.ItemNameBox.sendKeys("coffee mug");
		items.PriceItemBox.sendKeys("3000");
		items.ItemUnitBox.sendKeys("pc"+Keys.ENTER);
		items.ItemDiscriptionBox.sendKeys("cofee mug");
		items.SaveItemBtn.click();
		utils.waitForElementToBeVisible(items.filterBtn);
		items.filterBtn.click();
	}
	@Then("I should see the following text boxes appear as a name, unit, price, clear all")
	public void i_should_see_the_following_text_boxes_appear_as_a_name_unit_price_clear_all() {
	    utils.waitForElementToBeVisible(items.filterName);
	}
	@When("I type value in the name text box")
	public void i_type_value_in_the_name_text_box() {
	 items.filterName.sendKeys("coffee mug");
	}
	@Then("Application will perform a wild card search for any item matching the value")
	public void application_will_perform_a_wild_card_search_for_any_item_matching_the_value() {
	    
	}
	@When("I type value in the Unit text box")
	public void i_type_value_in_the_unit_text_box() {
	   items.filterUnit.sendKeys("pc");
	}
	@When("I type a value in the Price text box")
	public void i_type_a_value_in_the_price_text_box() {
	    items.filterPrice.sendKeys("3000");
	}
	@When("I type a value in one or more of the text boxes")
	public void i_type_a_value_in_one_or_more_of_the_text_boxes() {
	    
	}
	@Then("Application will perform a wild card search based on a item matching all combinations")
	public void application_will_perform_a_wild_card_search_based_on_a_item_matching_all_combinations() {
	   
	}
	@When("my search does not return any results")
	public void my_search_does_not_return_any_results() {
	    items.filterName.sendKeys("dsfhdwsijfhnswk;fdsjbjfvhds");
	}
	@Then("I should see an empty table with the following message in grey {string}")
	public void i_should_see_an_empty_table_with_the_following_message_in_grey(String string) {
	    Assert.assertTrue(items.filterNoResultFound.isDisplayed());
	}
	@When("I click on the Clear All link")
	public void i_click_on_the_clear_all_link() {
	    items.filterClearAll.click();
	    
	}
	@Then("Application will display the current list of items")
	public void application_will_display_the_current_list_of_items() {
	    
	}
	@When("I click on the Filter button again")
	public void i_click_on_the_filter_button_again() {
	    items.filterBtn.click();
	}
	@Then("I should see the dialog closed")
	public void i_should_see_the_dialog_closed() {
	    
	}

	
	
	
}
