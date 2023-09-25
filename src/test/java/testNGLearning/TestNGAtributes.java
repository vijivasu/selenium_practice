package testNGLearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAtributes {
	
	@BeforeMethod
	
	public void beforeMethod()
	{
		System.out.println("This would be executed before the test case");
	}
	
	@Test (priority=3, alwaysRun= true)
	public void testCase1()
	{
		
		System.out.println("Test case 1");
	}
	
	@Test (priority=2, enabled=false)
	public void testCase2()
	{
		System.out.println("Test case 2");
	}
	
	@Test (priority=1, dependsOnMethods ="testCase1")
	public void testCase3()
	{
		System.out.println("Test case 3");
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This would be executed after the test case");
	}
	

}
