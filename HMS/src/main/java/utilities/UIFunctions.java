package utilities;

import org.openqa.selenium.By;
import org.testng.Assert;

import webPages.HomePage;
import webPages.LoginPage;
import webPages.RegistrationPage;

public class UIFunctions extends GenericMethods {
	
	public LoginPage login = null;
	public HomePage home = null;
	public RegistrationPage register = null;
	
	
	public void login() {

		input(login.userName, "admin", "UserName");
		input(login.password, "admin", "Password");
		click(login.getLogin(),"Login");

		if (driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed()) {
			System.out.println("Success");
		} else {

			Assert.fail();
		}
	}

}
