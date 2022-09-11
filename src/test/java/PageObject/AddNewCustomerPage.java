package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;
	public AddNewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement Customers_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[text()=' Customers']")
	WebElement Customer_item;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement Addbtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailadd;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passadd;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstnameadd;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastnameadd;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement maleradiobtn;
	
	@FindBy(xpath="//input[@id='Female_Male']")
	WebElement femaleradiobtn;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement DOB;
	
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement Compony;
	
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement taxexempt;
	
	@FindBy(xpath="//div[@role='listbox']//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']")
	WebElement newslatter;
	
	@FindBy(xpath="//div[@role='listbox']//ul[@id='SelectedCustomerRoleIds_taglist']")
	WebElement customerRoles;
	
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement manvendorid;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement addcommit;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
		
	}
	public void clickOnCustMenu() {
		Customers_menu.click();
	}
	
    public void clickOnCustMenu_itom() {
    	Customer_item.click();
	}
    public void clickOnAddbtn() {
    	Addbtn.click();
    }
    public void enterEmail(String email) {
    	emailadd.sendKeys(email);	
    }
    public void enterPassword(String password) {
	    passadd.sendKeys(password);
    }
    public void enterFirstName(String firstname) {
    	firstnameadd.sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
    	lastnameadd.sendKeys(lastname);
    }
    public void enterGender(String gender) {
    	if (gender.equals("Male")) {
    		maleradiobtn.click();
    	}else {
    		femaleradiobtn.click();
    	}
    }
    public void enterdob(String dob) {
    	DOB.sendKeys(dob);
    }
    
    public void entercomponyname(String compony) {
    	Compony.sendKeys(compony);
    }
    public void enterisTax() {
    	taxexempt.click();
    }
    public void enternewsletter(String newletter) {
    	newslatter.sendKeys(newletter);
    }
    public void entercustomerrole(String custrole) {
    	customerRoles.sendKeys(custrole);
    }
    public void managerofvendor(String value) {
    	Select drop=new Select(manvendorid);
    	drop.selectByVisibleText(value);
    }
    public void entercommit(String commit) {
    	addcommit.sendKeys(commit);
    }
    public void clicksavebtn() {
    	savebtn.click();
    }

}
