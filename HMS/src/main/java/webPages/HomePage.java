package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericMethods;

public class HomePage extends GenericMethods {

	public HomePage(WebDriver driver) {

		GenericMethods.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Registration")
	private WebElement registration;

	public WebElement getRegistration() {

		return registration;
	}

	@FindBy(how = How.LINK_TEXT, using = "Emergency Registration")
	private WebElement eRegistration;

	public WebElement getERegistration() {

		return eRegistration;
	}

}
