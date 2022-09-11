package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

//child class
public class StepDef extends BaseClass {

	@Before("@Sanity")
	public void setup1() {
		readconfig= new ReadConfig();
		System.out.println("setup1 sanity method executed....");

		String browser = readconfig.getBrowser();
		
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			default :
				driver= null;
				break;
		}
	}
	
	@Before("@regression")
	public void setup2() {
		System.out.println("setup2 regression method executed....");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeStep
	public void beforestepmethod() {
		System.out.println(" this is before steps");
	}

	//////////////// common method////////////
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {

		loginpage = new LoginPage(driver);
		addnewcustpg = new AddNewCustomerPage(driver);
		searchcustpg = new SearchCustomerPage(driver);
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
	}

	@And("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {

		loginpage.enterEmail(email);
		loginpage.enterPassword(password);

	}

	@And("click on login")
	public void click_on_login() {

		loginpage.clickLogin();
	}

	///////////// login feature////////////

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		String actualtitle = driver.getTitle();

		if (actualtitle.equals(expectedtitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() {
		loginpage.clicklogout();
	}

	@And("close the browser")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}

	////////////// Add new customer/////////////////

	@Then("user can view Dashboad")
	public void user_can_view_dashboad() {
		String actualtitle = addnewcustpg.getPageTitle();
		String expactedtitle = "Dashboard / nopCommerce administration";

		if (actualtitle.equals(expactedtitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("click on customer menu")
	public void click_on_customer_menu() {
		addnewcustpg.clickOnCustMenu();
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() {
		addnewcustpg.clickOnCustMenu_itom();
	}

	@When("click on add new button")
	public void click_on_add_new_button() {
		addnewcustpg.clickOnAddbtn();
	}

	@Then("user can see add new customer page")
	public void user_can_see_add_new_customer_page() {
		String actualtitle = addnewcustpg.getPageTitle();
		String expectedtitle = "Add a new customer / nopCommerce administration";

		if (actualtitle.equals(expectedtitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {
		// addnewcustpg.enterEmail("vicky123@gmail.com");
		addnewcustpg.enterEmail(generateEmailId() + "gmail.com");
		addnewcustpg.enterPassword("122345");
		addnewcustpg.enterFirstName("viki");
		addnewcustpg.enterLastName("jadhav");
		addnewcustpg.enterGender("Male");
		addnewcustpg.enterdob("9/03/1993");
		addnewcustpg.entercomponyname("adflix");
		// addnewcustpg.enternewsletter("farar kaidi");
		// addnewcustpg.entercustomerrole("dispatch");
		addnewcustpg.managerofvendor("Vendor 2");
		addnewcustpg.entercommit("jay jay shiv shankar");
	}

	@When("click on save button")
	public void click_on_save_button() {
		addnewcustpg.clicksavebtn();
	}

	@Then("user can see conformation msg {string}")
	public void user_can_see_conformation_msg(String expecterdConfirmationMsg) {
		String actualtitle = "The new customer has been added successfully.";
		if (actualtitle.equals(expecterdConfirmationMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

//	@Then("close browser")
//	public void close_browser() {
//		driver.quit();
//	}

///////////////search customer///////////////

	@When("enter customer email")
	public void enter_customer_email() {
		searchcustpg.enteremailadd("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchcustpg.clickonSearchbtn();
	}

//////////////search cust by name///////////

	@When("enter customer firstname")
	public void enter_customer_firstname() {
		searchcustpg.firstname("Victoria");
	}

	@When("enter customer lastname")
	public void enter_customer_lastname() {
		searchcustpg.lastname("Terces");
	}

	//@After
	public void teardown(Scenario sc) {
		System.out.println("teardown method executed....");
		if(sc.isFailed()==true) {
			String filepath="C:\\Users\\admin\\eclipse-workspace\\CucumberFramework\\Screenshots\\failedtest.png";
			TakesScreenshot ts=((TakesScreenshot)driver);
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(filepath);
			
	        try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			//Attached image file report(data,media type,name of attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
//	@After(order=1)
//	public void teardown2() {
//		System.out.println("teardown2 method executed....");
//		driver.quit();
//	}

	@AfterStep
	public void aftertestmethod() {
		System.out.println("this is after test method");
	}
}