package step_defintions;

import org.junit.Assert;
import org.openqa.selenium.By;
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

public class CraterUpdateItemTest {
	
	CraterDashboardPage dashboard = new CraterDashboardPage();
	CraterItemsPage items = new CraterItemsPage();
	CreaterLoginPage login = new CreaterLoginPage();
	BrowserUtils utils = new BrowserUtils();
	


	@When("I select the item {string}")
	public void i_select_the_item(String item) {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitForElementToBeVisible(items.FirstItemCheckBox);
	    WebElement target = Driver.driver.findElement(By.xpath("//*[text()='"+item+"']"));
	    target.click();
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



	
}
