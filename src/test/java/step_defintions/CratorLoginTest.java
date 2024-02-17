package step_defintions;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CreaterLoginPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.Driver;

public class CratorLoginTest {

	CreaterLoginPage login = new CreaterLoginPage();
	BrowserUtils utils = new BrowserUtils();
	CraterDashboardPage dashboard = new CraterDashboardPage();
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    Driver.getDriver().get(DataReader.getProperty("crater_url"));
	}

	@When("user entres a valid email and valid password")
	public void user_entres_a_valid_email_and_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
		utils.waitForElementToBeVisible(login.emailInputBox);
	    utils.sendkeysWithActionsClass(login.emailInputBox, DataReader.getProperty("crater_email"));
	    login.passwordInputBox.sendKeys(DataReader.getProperty("crater_password"));
	}
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		  login.loginBtn.click();
	}
	@Then("user is logged in successfully")
	public void user_is_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		utils.waitForElementToBeVisible(dashboard.TextDisplayed);
		Assert.assertTrue(dashboard.TextDisplayed.isDisplayed());
	}
	 	
	@When("user entres invalid {string} and {string}")
	public void user_entres_invalid_and(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    utils.waitForElementToBeVisible(login.emailInputBox);
	    utils.sendkeysWithActionsClass(login.emailInputBox, email);
	    login.passwordInputBox.sendKeys(password);
	}
	@Then("user should not be logged in")
	public void user_should_not_be_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	  utils.waitForElementToBeVisible(login.loginBtn);
	  Assert.assertTrue(login.loginBtn.isDisplayed());
	}
	
}
