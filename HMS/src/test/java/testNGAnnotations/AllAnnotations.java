package testNGAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllAnnotations {
	
	@Test
	public void f() {
		
		System.out.println("First");
	}
	
	@Test
	public void show() {
		
		System.out.println("Show");
	}

	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("beforeMethod-1");
	}

	@AfterMethod
	public void afterMethod() {
		
		System.out.println("afterMethod-1");
	}

	@BeforeClass
	public void beforeClass() {
		
		System.out.println("beforeClass-1");
	}

	@AfterClass
	public void afterClass() {
		
		System.out.println("afterClass-1");
	}

	@BeforeTest
	public void beforeTest() {
		
		System.out.println("beforeTest-1");
	}

	@AfterTest
	public void afterTest() {
		
		System.out.println("afterTest-1");
	}

	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("beforeSuite-1");
	}

	@AfterSuite
	public void afterSuite() {
		
		System.out.println("afterSuite-1");
	}

}
