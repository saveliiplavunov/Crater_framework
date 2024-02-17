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
	
}
