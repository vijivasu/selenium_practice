package testNGLearning;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
	
WebDriver driver=null;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void launchBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void verifyTitle()
	{
		try
		{
			driver.get("https://www.google.com");
			
			String expectedTitle="Google";
			
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			
			driver.findElement(By.name("q")).sendKeys("Cross browser Testing");
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
