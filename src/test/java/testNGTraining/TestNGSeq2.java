package testNGTraining;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSeq2 {
	public FirefoxDriver driver;
	@Test
	public void LogintoGoogle() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}
	
	
}
