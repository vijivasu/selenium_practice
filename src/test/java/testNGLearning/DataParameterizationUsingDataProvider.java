package testNGLearning;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataParameterizationUsingDataProvider {

	WebDriver driver = null;

	@BeforeMethod
	public void browserlaunch() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@Test (dataProvider="fetchData")
	public void search(String urlName, String searchValue) {

		try {
			driver.get(urlName);

			WebElement searchField = driver.findElement(By.name("q"));
			searchField.clear();
			searchField.sendKeys(searchValue);
			Thread.sleep(2000);

			Assert.assertTrue(searchField.getAttribute("value").equalsIgnoreCase(searchValue));

			System.out.println("Assertion Passed");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {

		return new Object[][] { { "https://www.google.com", "Selenium Learning" },
				{ "https://www.google.com", "TestNG" }, 
				{ "https://www.google.com", "Cucumber" } };

	}

}
