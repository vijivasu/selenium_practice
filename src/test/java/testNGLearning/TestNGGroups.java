package testNGLearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGGroups {
	
	@BeforeMethod (alwaysRun=true)
	public void beforeMethod()
	{
		System.out.println("This would be executed before the test case");
	}
	
	@Test (groups={"smoke"})
	public void testCase1()
	{
		
		System.out.println("Test case 1");
	}
	
	@Test (groups= {"regression"})
	public void testCase2()
	
	{
		System.out.println("Test case 2");
	}
	
	@Test (groups= {"regression","smoke"})
	public void testCase3()
	{
		System.out.println("Test case 3");
	}
	
	
	@AfterMethod (alwaysRun=true)
	public void afterMethod()
	{
		System.out.println("This would be executed after the test case");
	}
	

}
