package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterItemsPage {

	public CraterItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//a[@href='/admin/items']")
	public  WebElement ItemsLink;
	
	@FindBy(xpath="//h3[text()=\"New Item\"]")
	public  WebElement ItemsPageHeader;
	
	@FindBy(xpath="//button[starts-with(@class, 'inline-flex')][2]")
	public  WebElement AddItemBtn;
	
	@FindBy(xpath="//input[@type=\"text\" and starts-with(@class, \"font-base\")]")
	public WebElement ItemNameBox;
	
	@FindBy(xpath="//input[@id='0']")
	public  WebElement PriceItemBox;
	
	@FindBy(xpath="//input[@type=\"text\" and starts-with(@class,\"w-full\")]")
	public  WebElement ItemUnitBox;
	
	
	@FindBy(xpath="//textarea[@name='description']")
	public  WebElement ItemDiscriptionBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public  WebElement SaveItemBtn;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	public  WebElement FirstItemCheckBox;
	
	@FindBy(xpath="//span[contains(@class,'flex')]")
	public WebElement ActionBtn;
	
	@FindBy(xpath="//a[@role='menuitem']")
	public WebElement DeleteBtn;
	
	@FindBy(xpath="//button[text()=\"Ok\"]")
	public WebElement ConfirmationBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement UpdateItemBtn;
	
	@FindBy(xpath="//*[text()='books']")
	public WebElement BooksItem;
	
	@FindBy(xpath="(//*[text()='Edit Item'])[1]")
	public WebElement EditItemHeader;
	
	@FindBy(xpath="//*[text()='Item updated successfully']")
	public WebElement UpdateConfirmation;
	
	
	
	
}
