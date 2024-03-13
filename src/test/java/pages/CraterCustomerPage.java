package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterCustomerPage {

	public CraterCustomerPage() { 
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="(//a[@href=\"/admin/customers\"])[1]")
	public WebElement customerPage;
	
	@FindBy(xpath="//h3[text()=\"Customers\"]")
	public WebElement customerTitle;
	
	
	
}
