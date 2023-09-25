package testNGLearning;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGParallel1 {
	
WebDriver driver=null;
	
	@BeforeMethod
	public void launchBrowser()
	{
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	@Test
	public void launchGuru99()
	{
		driver.get("https://www.guru99.com/");
	}
	
	@Test
	public void launchJavaTPoint()
	{
		driver.get("https://www.javatpoint.com/");
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}

}
