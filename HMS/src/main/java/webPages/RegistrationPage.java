package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
	
	@FindBy(how=How.NAME,using="PATIENT_CAT")
	WebElement patient;
	
	public WebElement getPatient() {
		
		return patient;
	}

}
