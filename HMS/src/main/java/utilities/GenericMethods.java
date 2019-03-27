package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import extentReport.Reports;

public class GenericMethods extends Reports {

	
	public void input(WebElement ele, String testData, String fieldName) {

		try {
			if (ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(testData);
				logger.log(Status.INFO, "User Entered " + testData + " in " + fieldName);
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Enter "+testData+ " in "+ fieldName);
			Assert.fail(e.getMessage());
		}
	}

	public void click(WebElement ele, String fieldName) {

		try {
			if (ele.isDisplayed()) {
				explicitWaitClick(ele);
				ele.click();
				logger.log(Status.INFO, "User Clicked On " + fieldName);
			}
		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Click On "+ fieldName);
			Assert.fail(e.getMessage());
		}
	}

	public void selectByText(WebElement ele, String testData, String fieldName) {

		try {
			new Select(ele).selectByVisibleText(testData);
			logger.log(Status.INFO, "User Selected " + testData + " from " + fieldName);
		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Select "+testData+ " in "+ fieldName);
			Assert.fail(e.getMessage());
		}
	}

	public void selectByValue(WebElement ele, String testData, String fieldName) {

		try {
			new Select(ele).selectByValue(testData);
			logger.log(Status.INFO, "User Selected " + testData + " from " + fieldName);
		} catch (Exception e) {
			logger.log(Status.FAIL, "Failed to Select "+testData+ " in "+ fieldName);
			Assert.fail(e.getMessage());
		}
	}

	public void explicitWait(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void explicitWaitClick(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public String getText(WebElement ele) {
		String text = null;
		if (ele.isDisplayed()) {

			text = ele.getText().trim();
		}
		return text;

	}

	public String getFirstOption(WebElement ele) {
		String text = null;
		text = new Select(ele).getFirstSelectedOption().getText().trim();
		return text;
	}

	public void acceptAlert() {

		driver.switchTo().alert().accept();
	}

	public void switchToFrame(WebElement ele) {

		driver.switchTo().frame(ele);
	}

	public void switchToParent() {

		driver.switchTo().defaultContent();
	}

}
