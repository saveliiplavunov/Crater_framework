package step_defintions;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import pages.CreaterLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class CratorAddItemUI {

	BrowserUtils utils = new BrowserUtils();
	CraterDashboardPage dash = new CraterDashboardPage();
	CraterItemsPage items = new CraterItemsPage();
	CreaterLoginPage login = new CreaterLoginPage();
	
	@Given("I am an external user of the Prime Tech Invoice Application")
	public void i_am_an_external_user_of_the_prime_tech_invoice_application() {
		
	}
	@Given("I have logged in to the application")
	public void i_have_logged_in_to_the_application() {
	    utils.sendkeysWithActionsClass(login.emailInputBox, DataReader.getProperty("crater_email"));
	    login.passwordInputBox.sendKeys(DataReader.getProperty("crater_password"));
	    login.loginBtn.click();
	}
	@When("I click on the Items Menu Link")
	public void i_click_on_the_items_menu_link() {
	    utils.waitForElementToBeVisible(dash.ItemsLink);
	    dash.ItemsLink.click();
	}
	@Then("I should be navigated to a page titled Items")
	public void i_should_be_navigated_to_a_page_titled_items() {
	    utils.waitForElementToBeVisible(items.ItemsPageHeader);
	    Assert.assertTrue(items.ItemsPageHeader.isDisplayed());
	}
	@Then("I should see the menu navigation path as Home Items placed under Items")
	public void i_should_see_the_menu_navigation_path_as_home_items_placed_under_items() {
	   Assert.assertTrue(items.path.isDisplayed());
	}
	@Then("I should see a secondary button titled Filter with a filter icon")
	public void i_should_see_a_secondary_button_titled_filter_with_a_filter_icon() throws InterruptedException {
		Thread.sleep(3000);
	   Assert.assertTrue(items.items_page_filter_btn.isDisplayed());
	}
	@Then("I should see a primary button titled + Add Item")
	public void i_should_see_a_primary_button_titled_add_item() {
	    Assert.assertTrue(items.AddItemBtn.isDisplayed());
	}
	@Then("I should see a table with the following columns")
	public void i_should_see_a_table_with_the_following_columns() {
	    
	}
	@Then("Seclect All checkbox.NAME.UNIT.PRICE.ADDED ON")
	public void seclect_all_checkbox_name_unit_price_added_on() {
	    Assert.assertTrue(items.FirstItemCheckBox.isDisplayed());
	    Assert.assertTrue(items.nameText.isDisplayed());
	    Assert.assertTrue(items.unitText.isDisplayed());
	    Assert.assertTrue(items.priceText.isDisplayed());
	    Assert.assertTrue(items.addedOnText.isDisplayed());
	}
	@Then("Link icon showing three dots with the following options:")
	public void link_icon_showing_three_dots_with_the_following_options() {
	    Assert.assertTrue(items.items_page_3dot_menu.isDisplayed());
	    items.items_page_3dot_menu.click();
	}
	@Then("Link with an edit icon.")
	public void link_with_an_edit_icon() {
	    utils.waitForElementToBeVisible(items.items_page_3dot_edit_option);
	    Assert.assertTrue(items.items_page_3dot_edit_option.isDisplayed());
	}
	@Then("Delete with a delete icon.")
	public void delete_with_a_delete_icon() {
		 Assert.assertTrue(items.items_page_3dot_delete_option.isDisplayed());
	}
	@Then("Pagination text as follows: Showing total items results")
	public void pagination_text_as_follows_showing_to_of_total_items_results() {
	    Assert.assertTrue(items.paginationText.isDisplayed());
	}
	@When("user click on the right arrow")
	public void user_click_on_the_left_arrow() {
	  items.rightArrow.click();
	}
	@Then("user should be navigated to next page")
	public void user_should_be_navigated_to_previous_page() {
	    utils.waitUntilElementClickable(items.leftArrow);
	    items.secondPage.isSelected();
	}
	@When("user click on the left arrow")
	public void user_click_on_the_right_arrow() throws InterruptedException{
		Thread.sleep(2000);
	    items.leftArrow.click();
	}
	@Then("user should be naviagated to previous page")
	public void user_should_be_naviagated_to_next_page() throws InterruptedException {
	    Thread.sleep(2000);
	    items.firstPage.isSelected();
	}
	@When("user is on the first page")
	public void user_is_on_the_first_page() {
		items.firstPage.isSelected();
	}
	@Then("left arrow should be disabled")
	public void left_arrow_should_be_disabled() throws InterruptedException {
		Thread.sleep(2000);
	    Assert.assertTrue(items.leftArrow.isEnabled());
	}
	@When("user is on the last page")
	public void user_is_on_the_last_page() {
	    items.lastPage.click();
	}
	@Then("right arrow should be disabled")
	public void right_arrow_should_be_disabled() throws InterruptedException {
	    Thread.sleep(2000);
	    Assert.assertTrue(items.rightArrow.isEnabled());
	}
	
	@When("I click on +Add Item")
	public void i_click_on_add_item() {
	    utils.waitForElementToBeVisible(items.AddItemBtn);
	    items.AddItemBtn.click();
	}
	@Then("I Should be directed tot the create Item page")
	public void i_should_be_directed_tot_the_create_item_page() {
	    
	}
	@Then("I shoud see the page title New Item")
	public void i_shoud_see_the_page_title_new_item() {
	    utils.waitForElementToBeVisible(items.NewItemPageHeader);
	    Assert.assertTrue(items.NewItemPageHeader.isDisplayed());
	}
	@Then("The patyh underneath the title should be Home\\/Items\\/New Item")
	public void the_patyh_underneath_the_title_should_be_home_items_new_item() {
	   String path =items.newItemPath.getText();
	   if (path.contains("New Item")) {
		   Assert.assertTrue(items.newItemPath.isDisplayed());
	   }
	}
	@Then("a textbox labeled Name")
	public void a_textbox_labeled_name() {
	    Assert.assertTrue(items.ItemNameBox.isDisplayed());
	}
	@Then("a textbox labled Price")
	public void a_textbox_labled_price() {
	    Assert.assertTrue(items.PriceItemBox.isDisplayed());
	}
	@Then("a dropdown labled unit")
	public void a_dropdown_labled_unit() {
	    Assert.assertTrue(items.ItemUnitBox.isDisplayed());
	}
	@Then("a comment box labled Description")
	public void a_comment_box_labled_description() {
	    Assert.assertTrue(items.ItemDiscriptionBox.isDisplayed());
	}
	@Then("a primary button labeled Save Item")
	public void a_primary_button_labeled_save_item() {
	    Assert.assertTrue(items.SaveItemBtn.isDisplayed());
	}
	
	


}
