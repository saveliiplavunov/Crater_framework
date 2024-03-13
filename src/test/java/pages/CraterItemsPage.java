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
	
	@FindBy(xpath="//h3[text()=\"Items\"]")
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
	
	@FindBy(xpath="//ol[@class='flex flex-wrap py-4 text-gray-900 rounded list-reset']")
	public WebElement path;
	
	  @FindBy (xpath = "//button[text()='Filter ']")
	  public WebElement items_page_filter_btn;
	
	@FindBy(xpath="//th[text()=\"Name \"]")
	public WebElement nameText;
	
	@FindBy(xpath="//th[text()=\"Unit \"]")
	public WebElement unitText;
	
	@FindBy(xpath="//th[text()=\"Price \"]")
	public WebElement priceText;
	
	@FindBy(xpath="//th[text()=\"Added On \"]")
	public WebElement addedOnText;
	
	@FindBy (xpath = "(//button[contains(@id, 'headlessui-menu-button')])[3]")
    public WebElement items_page_3dot_menu;
	
	@FindBy (xpath = "//a[text()=' Edit']")
	public WebElement items_page_3dot_edit_option;
	
	 @FindBy (xpath = "//a[text()=' Delete']")
	 public WebElement items_page_3dot_delete_option;
	
	 @FindBy(xpath="//p[@class=\"text-sm text-gray-700\"]")
	 public WebElement paginationText;
	 
	 @FindBy(xpath="//a[contains(@class,'border-gray-300 rounded-r-md hover:bg-gray-50')]")
	 public WebElement rightArrow;
	 
	 @FindBy(xpath="//a[contains(@class,'bg-white border border-gray-300 rounded-l-md hover:bg-gray-50')]")
	 public WebElement leftArrow;
	 
	 @FindBy(xpath="//a[contains(@class,'z-10 bg-primary-50 border-primary-500')]")
	 public WebElement secondPage;
	 
	 @FindBy(xpath="//a[contains(@class,'z-10 bg-primary-50 border-primary-500')]")
	 public WebElement firstPage;
	 
	 @FindBy(xpath="//a[contains(@class,'bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 text-sm font-medium border')]")
	 public WebElement lastPage;
	 
	 @FindBy(xpath="//h3[text()=\"New Item\"]")
	public  WebElement NewItemPageHeader;
	 
	 @FindBy(xpath="//ol[@class=\"flex flex-wrap py-4 text-gray-900 rounded list-reset\"]")
	 public WebElement newItemPath;
	 
	 @FindBy(xpath="//span[text()='Field is required']")
	 public WebElement FieldIsRequiredMsg;
	 
	 @FindBy(xpath="(//input[@type=\"checkbox\"])[1]")
	 public WebElement selectAllBox;
	 
	 @FindBy(xpath="//span[text()=\"Actions \"]")
	 public WebElement actionBtn;
	 
	 @FindBy(xpath="//a[text()=\" Delete\"]")
	 public WebElement deleteDropDown;
	 
	 @FindBy(xpath="//p[text()=\"You will not be able to recover these Items\"]")
	 public WebElement confirmMsgForDelete;
	 
	 @FindBy(xpath="//*[text()=\"Items deleted successfully\"]")
	 public WebElement itemsDeletedSucces;
	 
	 @FindBy(xpath="//button[text()=\"Filter \"]")
	 public WebElement filterBtn;
	 
	 @FindBy(xpath="//input[@name=\"name\"]")
	 public WebElement filterName;
	 
	 @FindBy(xpath="(//input[@type=\"text\"])[3]")
	 public WebElement filterUnit;
	 
	 @FindBy(xpath="//input[@type=\"tel\"]")
	 public WebElement filterPrice;
	 
	 @FindBy(xpath="//label[text()=\"Clear All\"]")
	 public WebElement filterClearAll;
	 
	 @FindBy(xpath="//span[text()=\"No Results Found\"]")
	 public WebElement filterNoResultFound;
	 
	 
	
	
}
