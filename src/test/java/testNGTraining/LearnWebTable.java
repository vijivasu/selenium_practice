package testNGTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {

		FirefoxDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> headers = table.findElements(By.tagName("th"));
		
		for(WebElement header: headers) {
			String text = header.getText();
			System.out.println(text);
		}
		
		List<WebElement> Allrows = driver.findElements(By.xpath("//table[@id='simpletable']//tbody/tr"));
		
		int size = Allrows.size();
		System.out.println(size);
		if(size==3) {
			System.out.println("pass");}
		else{
			 
				System.out.println("fail");
			}
		
		for(WebElement rows:Allrows) {
		rows.findElements(By.tagName("td"));
			
		}
		}
	}


