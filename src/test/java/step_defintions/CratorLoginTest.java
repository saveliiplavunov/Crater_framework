package step_defintions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	
	@Then("user should be able so see Page Title {string},textbox with label {string},textbox with label {string},link title {string},primary button {string},text area {string},heading {string},and second heading {string}")
	public void user_should_be_able_so_see_page_title_textbox_with_label_textbox_with_label_link_title_primary_button_text_area_heading_and_second_heading(String title, String email, String password, String forgotPassword, String loginBtn, String text1, String heading1, String heading2) {
	    // Write code here that turns the phrase above into concrete actions
	Assert.assertTrue(Driver.getDriver().getTitle().equals(title));
	Assert.assertTrue(login.EmailTextBox.getText().equals(email));
	Assert.assertTrue(login.PasswordTextBox.getText().equals(password));
	Assert.assertTrue(login.forgotPassLink.getText().equals(forgotPassword));
	Assert.assertTrue(login.loginBtnText.getText().equals(loginBtn));
	Assert.assertTrue(login.text1.getText().equals(text1));
	Assert.assertTrue(login.heading1.getText().equals(heading1));
	Assert.assertTrue(login.heading2.getText().equals(heading2));
	
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
