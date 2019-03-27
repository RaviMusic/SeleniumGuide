package testNG;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import readData.RetrieveTestData;
import utilities.GenericMethods;

public class EmergencyRegistration extends GenericMethods {
	
	public Map<String,String> data = RetrieveTestData.readData("HMS", "ERegistration");
	public Map<String,String> data1 = RetrieveTestData.readData("HMS", "PRegistration");

	@Test(priority = 0)
	public void login() throws Exception {

		input(login.userName, "admin", "UserName");
		input(login.password, "admin", "Password");
		click(login.getLogin(), "Login");
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed()) {
			System.out.println("Success");
		} else {

			Assert.fail();
		}
	}

	@Test(priority = 1, dependsOnMethods = "login")
	public void pRegistration() {

		click(home.getRegistration(), "Registration");

		String name = driver.findElement(By.linkText("Emergency Registration")).getText();

		System.out.println(name);

		home.getERegistration().click();

		selectByText(register.getPatient(), data.get("PatientCat"), "Patient Cat");

		System.out.println(getFirstOption(register.getPatient()));

		selectByText(driver.findElement(By.name("TITLE")), "Mr.", "Title");

		input(driver.findElement(By.name("AGE")), "78", "Age");

		new Select(driver.findElement(By.name("SE"))).selectByVisibleText(data.get(""));

		driver.findElement(By.name("PNT_NAME")).sendKeys("Selenium");

		System.out.println(driver.findElement(By.name("PNT_NAME")).getAttribute("innerHTML"));

		driver.findElement(By.name("submit")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}
}
