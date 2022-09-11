package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitle {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");

		WebElement txt_username = driver.findElement(By.name("Email"));
		WebElement txt_password = driver.findElement(By.name("Password"));
		WebElement loginbtn = driver.findElement(By.xpath("//button[text()='Log in']"));

		txt_username.clear();
		txt_password.clear();
		txt_username.sendKeys("admin@yourstore.com");
		txt_password.sendKeys("admin");
		loginbtn.click();

		String title_login = driver.getTitle();
		System.out.println("title is "+title_login);
		WebElement loginout = driver.findElement(By.xpath("//a[text()='Logout']"));

		loginout.click();
		String title_logout = driver.getTitle();
		System.out.println("title is "+title_logout);
	}
}
