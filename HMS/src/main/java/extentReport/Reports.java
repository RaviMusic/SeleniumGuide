package extentReport;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Constants;
import webPages.HomePage;
import webPages.LoginPage;
import webPages.RegistrationPage;

public class Reports {

	public ExtentHtmlReporter htmlReporter = null;
	public ExtentReports extent = null;
	public ExtentTest logger = null;
	public LoginPage login = null;
	public HomePage home = null;
	public RegistrationPage register = null;

	public static WebDriver driver = null;

	@BeforeSuite(alwaysRun=true)
	public void configReport() {

		// Mention the path of the html file
		htmlReporter = new ExtentHtmlReporter("./ExtentReports/TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@AfterSuite(alwaysRun=true)
	public void endReport() {

		extent.flush();
	}

	@BeforeMethod(alwaysRun=true)
	public void initPageObjects(Method method) {
		
		logger = extent.createTest(method.getName(),method.getDeclaringClass().getName());

		login = new LoginPage(driver);
		home = new HomePage(driver);
		register = PageFactory.initElements(driver, RegistrationPage.class);
	}

	@BeforeClass(alwaysRun=true)
	@Parameters({"browser","application"})
	public void initApplication(String browserName,String app) {

		getBrowser(browserName);
		getApplication(app);
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApplication() {
		
		driver.close();
	}

	public void getBrowser(String name) {

		switch (name) {
		case "chrome":
			System.setProperty(Constants.chromeKey, Constants.chromePath);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty(Constants.firefoxKey, Constants.firefoxPath);
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty(Constants.ieKey, Constants.iePath);
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("Please Provide valid browser name");
			break;
		}

	}

	public void getApplication(String name) {

		switch (name.toLowerCase()) {
		case "hms":
			driver.get("http://selenium4testing.com/hms/");
			break;
		case "amazon":
			driver.get("https://www.amazon.in/");
			break;
		case "orangeHRM":
			driver.get("https://opensource-demo.orangehrmlive.com/");
			break;

		default:
			System.out.println("Please Provide valid browser name");
			break;
		}
		driver.manage().window().maximize();
	}

}
