package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericMethods;

public class LoginPage {
	
	// WebElement ele = driver.findElement(By.name("username"));
	
	public LoginPage(WebDriver driver) {
		
		GenericMethods.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.NAME,using="username")
	public WebElement userName;
	
	@FindBy(how=How.NAME,using="password")
	public WebElement password;
	
	@FindBy(how=How.NAME,using="submit")
	private WebElement login;
	
	public WebElement getLogin() {
		
		return login;
	}

}
