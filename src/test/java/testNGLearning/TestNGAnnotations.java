package testNGLearning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	/*
	
	@BeforeSuite
		@BeforeTest
			@BeforeClass
				@BeforeMethod
					@Test
				@AfterMethod
			@AfterClass
		@AfterTest
	@BeforeSuite
	
	
	
	@BeforeMethod: This will be executed before every @test annotated method.
	•	@AfterMethod: This will be executed after every @test annotated method.
	•	@BeforeClass: This will be executed before first @Test method execution. It will be executed one only time throughout the test case.
	•	@AfterClass: This will be executed after all test methods in the current class have been run
	•	@BeforeTest: This will be executed before the first @Test annotated method. 
	•	@AfterTest: A method with this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag in the TestNG.xml file.
	•	@BeforeSuite: It will run only once, before all tests in the suite are executed.
	•	@AfterSuite: A method with this annotation will run once after the execution of all tests in the suite is complete.
	*
	*/
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("It will run only once, before all tests in the suite are executed ");
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("A method with this annotation will run once after the execution of all tests in the suite is complete. ");
		
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("This will be executed before the first @Test annotated method. ");
		
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("A method with this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag in the TestNG.xml file. ");
		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This will be executed before first @Test method execution. It will be executed one only time throughout the test case. ");
		
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("This will be executed after all test methods in the current class have been run ");
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This will be executed before every @test annotated method. ");
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This will be executed after every @test annotated method. ");
		
	}
	@Test (groups= {"smoke"})
	public void tc1()
	{
		System.out.println("TC1 ");
		
	}
	@Test (groups= {"regression"})
	public void tc2()
	{
		System.out.println("TC2 ");
		
	}

}


/*
 * BS, BT , BC , BM, TC1, AM, BM, TC2, AM, AC, AT, AS
 */
