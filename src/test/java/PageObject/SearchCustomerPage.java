package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement searchemail;
	
	@FindBy(id="search-customers1")
	WebElement searchbtn;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;
	
    @FindBy(xpath="//table[@role='grid']//tbody/tr")
	List<WebElement> tablerows;
    
    @FindBy(id="SearchFirstName")
    WebElement Firstname;
    
    @FindBy(id="SearchLastName")
    WebElement Lastname;
	
//	@FindBy(xpath="//table[@role='grid']//tbody/tr[1]/td")
//	List<WebElement> tablecolumns;
	
	public void enteremailadd(String emailadd) {
		searchemail.sendKeys(emailadd);
	}
	public void clickonSearchbtn() throws InterruptedException {
		searchbtn.click();
		Thread.sleep(3000);
	}
	public boolean searchCustomerByEmail(String email) {
		
		boolean found=false;
		int ttlrows=tablerows.size();
		
		//int ttcolumns=tablecolumns.size();
	
			WebElement webemail= ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[1]/td[2]"));
			String actualemailadd=webemail.getText();
			if(actualemailadd.equals(email)) {
				found=true;
		
		}
		return found;
	}
		/////////////////search cust by name//////////////
	public void firstname(String firstnametxt) {
		Firstname.sendKeys(firstnametxt);
	}
	
	public void lastname(String lastnametxt) {
	    Lastname.sendKeys(lastnametxt);
	}
	}

