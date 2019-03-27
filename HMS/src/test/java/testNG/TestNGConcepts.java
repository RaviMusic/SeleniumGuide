package testNG;

import org.testng.annotations.Test;

import utilities.GenericMethods;

public class TestNGConcepts extends GenericMethods {
	
	/* Group Execution
	 * 
	 * Parameters
	 * 
	 * execute same test case multiple times
	 * 
	 */
	
	@Test(priority=0,groups="smoke",invocationTimeOut=1000)
	public void login() {
		
		System.out.println("Execute Login Test Case");
	}
	
	
	@Test(priority=1,groups="reg")
	public void registration() {
		
		System.out.println("Execute Registration");
	}
	
	@Test(priority=2,invocationCount=3)
	public void searchRegistration() {
		
		System.out.println("Execute Search Registration");
	}
	
	@Test(priority=3,groups="smoke")
	public void show() {
		
		System.out.println("Execute Show");
	}
	

}
