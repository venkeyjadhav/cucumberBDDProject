package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver) 
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@class='nav-link']")
	WebElement logoutbtn;
	
	public void enterEmail(String emailadd) {
		email.clear();
		email.sendKeys(emailadd);
	}
	
	public void enterPassword(String pwd) {
	    password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginbtn.click();
	}
	
	public void  clicklogout() {
		logoutbtn.click();
	}
	
}
