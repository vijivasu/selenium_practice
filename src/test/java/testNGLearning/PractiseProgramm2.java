package testNGLearning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PractiseProgramm2 {

	WebDriver driver = null;

	@BeforeMethod
	public void greenkartBaseClass() {

		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		System.out.println("Browser launched successfully");
		System.out.println("Browser successfully maximized");
		
	}

	public void clickOnTopDeals() throws InterruptedException {
		String windowHandle = driver.getWindowHandle();
		System.out.println("First Window" + windowHandle);
		driver.findElement(By.xpath("//a[contains(text(), 'Top Deals')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> winList = new ArrayList<String>(windowHandles);
		WebDriver window = driver.switchTo().window(winList.get(1));
		System.out.println(window.getCurrentUrl());
		System.out.println("Window handled applied successfully");
	}

	@Test
	public void findDiscountedPercentage() throws InterruptedException {

		clickOnTopDeals();

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered']"));

		System.out.println("Original price of each Item");
		int columnIndex1 = 1;
		List<WebElement> column2datas = table.findElements(By.xpath(".//tr/td [" + (columnIndex1 + 1) + " ]"));
		int noOfRowsForCol2 = column2datas.size();
		System.out.println(noOfRowsForCol2);

		for (int i = 0; i < noOfRowsForCol2; i++) {
			List<String> price = new ArrayList<String>();
			price.add(column2datas.get(i).getText());
			String original_price = column2datas.get(i).getText();
			int orgi_price = Integer.parseInt(original_price);
			System.out.println(orgi_price);
		}
				System.out.println("Price After Discount of each Item");
				int columnIndex2 = 2;
				List<WebElement> column3datas = table.findElements(By.xpath(".//tr/td [" + (columnIndex2 + 1 + " ]")));
				int noOfRowsForCol3 = column3datas.size();
				System.out.println(noOfRowsForCol2);

				for (int i = 0; i < noOfRowsForCol3; i++) {
					List<String> dicounted_price = new ArrayList<String>();
					dicounted_price.add(column3datas.get(i).getText());
					String discounted_price = column3datas.get(i).getText();
					int dis_price = Integer.parseInt(discounted_price);
					System.out.println(dis_price);
				}
			}


/*
 * for(int i=0;i<column3datas.size();i++) {
 * 
 * List<String> orgi_price = new ArrayList<String>(); List<String> dis_price =
 * new ArrayList<String>();
 * 
 * 
 * discounted_Percentage = float((orgi_price - dis_price) / orgi_price) * 100; }
 */
