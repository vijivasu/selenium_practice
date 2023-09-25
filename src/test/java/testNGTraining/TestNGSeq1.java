package testNGTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSeq1 {
	public FirefoxDriver driver;
	//public ChromeDriver driver;
	
	//No Static in TestNG , We can have Main method
	@Test
	public void test1() {
		//WebDriverManager.chromedriver().browserVersion("83.0.4103").setup();
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.quit();
	}
	
	
	
}
