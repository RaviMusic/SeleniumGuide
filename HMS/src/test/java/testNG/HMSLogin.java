package testNG;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import readData.RetrieveTestData;

public class HMSLogin {
	
	public Map<String,String> data = RetrieveTestData.readData("HMS", "ERegistration");

	@Test(priority=0)
	public void login() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\centillion\\Downloads\\DriverFiles\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://selenium4testing.com/hms/");

		driver.findElement(By.name("username")).clear();

		driver.findElement(By.name("username")).sendKeys(data.get("UserName"));

		driver.findElement(By.name("password")).clear();

		driver.findElement(By.name("password")).sendKeys(data.get("Password"));

		driver.findElement(By.name("submit")).click();
		
		if (driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed()) {
			
			System.out.println("Success");
		}else {
			
			Assert.fail();
		}
	}
	
	@Test(priority=1,dependsOnMethods="login")
	public void registration() {
		
		System.out.println("----------");
	}

}
