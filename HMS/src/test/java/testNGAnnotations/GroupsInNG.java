package testNGAnnotations;

import org.testng.annotations.Test;

import utilities.GenericMethods;

public class GroupsInNG extends GenericMethods{
	
	
	@Test(groups="smoke")
	public void addToCart() {
		
		System.out.println("add to cart");
	}
	
	
	@Test(priority=1,groups="reg")
	public void checkout() {
		
		System.out.println("Checkout");
		
	}

}
