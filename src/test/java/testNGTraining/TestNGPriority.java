package testNGTraining;

import org.testng.annotations.Test;

public class TestNGPriority {
	@Test (invocationCount =1)
	public void signUp() {
		System.out.println("SignUp");
	}
	@Test (priority = -1, dependsOnMethods = "signUp")
	public void login() {
		System.out.println("login");
	}
	@Test(dependsOnMethods = "login")
	public void searchProduct() {			
		System.out.println("search Product");
	}
	@Test(dependsOnMethods = "searchProduct")
	public void addToCart() {
		System.out.println("add To Cart");
		throw new RuntimeException();
	}
	
	@Test(dependsOnMethods = "addToCart")
	public void signOut() {
		System.out.println("Sign Out");
	}


}

