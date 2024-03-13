package step_defintions;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItemsPage;
import pages.CreaterLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;


public class CraterUpdateItemTest {
	
	CreaterLoginPage login = new CreaterLoginPage();
	BrowserUtils utils = new BrowserUtils();
	CraterItemsPage items = new CraterItemsPage();
	
	@Given("As an entity user I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("crater_url"));
	    utils.sendkeysWithActionsClass(login.emailInputBox,DataReader.getProperty("crater_email"));
	    login.passwordInputBox.sendKeys(DataReader.getProperty("crater_password"));
	    login.loginBtn.click();
	}


	@When("I select the item")
	public void i_select_the_item() {
		utils.waitForElementToBeVisible(items.ItemsLink);
		items.ItemsLink.click();
		utils.waitForElementToBeVisible(items.items_page_3dot_menu);
		items.items_page_3dot_menu.click();
		items.items_page_3dot_edit_option.click();
		
	    
	}
	@When("I should be on item details page")
	public void i_should_be_on_item_details_page() {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitForElementToBeVisible(items.EditItemHeader);
	    Assert.assertTrue(items.EditItemHeader.isDisplayed());
	}
	@When("I update the item price to {int} dollars")
	public void i_update_the_item_price_to_dollars(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitForElementToBeVisible(items.PriceItemBox);
	    items.PriceItemBox.clear();
	   items.PriceItemBox.sendKeys(String.valueOf(int1*100));
	}
	@When("I click Update Item button")
	public void i_click_update_item_button() {
	    // Write code here that turns the phrase above into concrete actions
	    items.UpdateItemBtn.click();
	    
	}
	@Then("The Item price is updated to {int} dollars")
	public void the_item_price_is_updated_to_dollars(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitForElementToBeVisible(items.UpdateConfirmation);
	    Assert.assertTrue(items.UpdateConfirmation.isDisplayed());
	}
	
	
	@When("click on the Select ALL checkbox in the Items Table OR check multiple rows")
	public void click_on_the_select_all_checkbox_in_the_items_table_or_check_multiple_rows() {
	    utils.waitForElementToBeVisible(items.FirstItemCheckBox);
	    items.selectAllBox.click();
	}
	@When("I click on the Actions dropdown")
	public void i_click_on_the_actions_dropdown() {
	    items.actionBtn.click();
	}
	@When("I click on Delete")
	public void i_click_on_delete() {
	    utils.waitForElementToBeVisible(items.deleteDropDown);
	    items.deleteDropDown.click();
	}
	@Then("I should see a alert icon Are you sure")
	public void i_should_see_a_alert_icon_are_you_sure() {
	    
	}
	@Then("I should see a message You will not be able to recover these items")
	public void i_should_see_a_message_you_will_not_be_able_to_recover_these_items() {
	    utils.waitForElementToBeVisible(items.confirmMsgForDelete);
	    Assert.assertTrue(items.confirmMsgForDelete.isDisplayed());
	}
	@Then("I click OK button")
	public void i_click_ok_button() {
	    items.ConfirmationBtn.click();
	}
	@Then("I should see a flash message Success Items deleted successfully with a close button to the right")
	public void i_should_see_a_flash_message_success_items_deleted_successfully_with_a_close_button_to_the_right() {
		utils.waitForElementToBeVisible(items.itemsDeletedSucces);
		Assert.assertTrue(items.itemsDeletedSucces.isDisplayed());
	}
	@Then("User I should be directed to the items table")
	public void user_i_should_be_directed_to_the_items_table() {
	    utils.waitForElementToBeVisible(items.ItemsPageHeader);
	    Assert.assertTrue(items.ItemsPageHeader.isDisplayed());
	}



	
}
