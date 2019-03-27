package testNG;

import org.testng.annotations.Test;

public class Annotations {
	
	//Ramya Annotations
	
	@Test(priority=1)
	public void show() {
		
		System.out.println("Welcome To TestNG-- Next Generation");
	}
	
	@Test(priority=2)
	public void addition() {
		
		System.out.println(5+6);
	}
	
	@Test(priority=0)
	public void sub() {
		
		System.out.println(897-76);
	}
	
	@Test(priority=3)
	public void login() {
		
		
	}
	
	@Test(priority=4,dependsOnMethods="login")
	public void registration() {
		
		
	}
	
}
