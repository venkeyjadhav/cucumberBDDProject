package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

//base class
public class BaseClass {

	public static WebDriver driver;
    public LoginPage loginpage;
	public AddNewCustomerPage addnewcustpg;
	public SearchCustomerPage searchcustpg;
	public ReadConfig readconfig;
	public String generateEmailId() {
		return RandomStringUtils.randomAlphabetic(5);
	}
}
