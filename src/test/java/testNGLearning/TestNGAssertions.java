package testNGLearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertions {
	
	WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void launchBrowser()
	{
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyTitleUsingAssertEquals()
	{
		try
		{
			driver.get("https://www.google.com");
			//String expectedTitle =  driver.findElement(By.xpath("//title")).getText();
			String expectedTitle = "Google";
//			System.out.println(expectedTitle);
			
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			driver.findElement(By.name("q")).sendKeys("learning assertions");
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void verifyTitleUsingAssertNotEquals()
	{
		try
		{
			driver.get("https://www.google.com");
			//String expectedTitle =  driver.findElement(By.xpath("//title")).getText();
			String expectedTitle = "Google1";
//			System.out.println(expectedTitle);
			
			Assert.assertNotEquals(driver.getTitle(), expectedTitle);
			driver.findElement(By.name("q")).sendKeys("learning assertions");
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void verifyTitleUsingAssertTrue()
	{
		driver.get("https://www.google.com");
		String expectedTitle = "Google";
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase(expectedTitle));
		driver.findElement(By.name("q")).sendKeys("learning assertions");

	}
	
	@Test
	public void verifyTitleUsingAssertFalse()
	{
		driver.get("https://www.google.com");
		String expectedTitle = "Google1";
		Assert.assertFalse(driver.getTitle().equalsIgnoreCase(expectedTitle));
		driver.findElement(By.name("q")).sendKeys("learning assertions");

	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		//driver.quit();
	}

}
