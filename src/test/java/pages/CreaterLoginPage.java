package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CreaterLoginPage {

	public CreaterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailInputBox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordInputBox;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	public WebElement loginBtn;
	
	@FindBy(xpath="//*[text()='Email ']")
	public WebElement EmailTextBox;
	
	@FindBy(xpath="//*[text()='Password ']")
	public WebElement PasswordTextBox;
	
	@FindBy(xpath="//*[text()='Forgot Password?']")
	public WebElement forgotPassLink;
	
	@FindBy(xpath="//*[text()='Login']")
	public WebElement loginBtnText;
	
	@FindBy(xpath="//*[text()='Copyright @ Crater Invoice, Inc. 2024']")
	public WebElement text1;
	
	@FindBy(xpath="//*[text()='Simple Invoicing for Individuals Small Businesses']")
	public WebElement heading1;
	
	@FindBy(xpath="//*[text()='Crater helps you track expenses, record payments & generate beautiful invoices & estimates.']")
	public WebElement heading2;
	
	
}
