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
	
	CraterDashboardPage dashboard = new CraterDashboardPage();
	CraterItemsPage items = new CraterItemsPage();
	CreaterLoginPage login = new CreaterLoginPage();
	BrowserUtils utils = new BrowserUtils();
	

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
		utils.waitForElementToBeVisible(dashboard.TextDisplayed);
		dashboard.ItemsLink.click();
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
	
	
	
}
