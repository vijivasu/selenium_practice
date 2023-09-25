package testNGLearning;

import java.time.Duration;
import java.util.List;

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

public class PractiseProgramm1 {

	WebDriver driver = null;
	
	@BeforeMethod
	public void greenkartBaseClass(){

		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
	}

	
	public void selectAddToCart() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder = 'Search for Vegetables and Fruits']")).sendKeys("ber");
		Thread.sleep(3000);
		
		List<WebElement> noOfItems = driver.findElements(By.xpath("//button[contains(text(), 'ADD TO CART')]"));
		System.out.println("Size-->"+noOfItems.size());
		
		for (WebElement item : noOfItems) {
			try {
				item.click();
				// break;

			} catch (StaleElementReferenceException e) {
				item = driver.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]"));
				// item.click();

			}

		}

	}
	
	public void itemsinCart() {
		WebElement items = driver.findElement(By.xpath("//div[@class='cart-info']//tr/td[3]/strong"));
		System.out.println(items);
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
	}

	@Test
	public void productionCheckout() throws InterruptedException {
		
		selectAddToCart();
		itemsinCart();
		
		// 1st Test case - Compare the Amount added in the cart with Total amount calculated

		WebElement table = driver.findElement(By.xpath("//table[@id='productCartTables']"));

		int ColumnIndex = 4;

		int sum = 0;
		List<WebElement> columnData = table.findElements(By.xpath(".//tr/td[" + (ColumnIndex + 1) + "]"));
		for (WebElement cell : columnData) {
			String text = cell.getText();
			try {
				int cellvalue = Integer.parseInt(text);
				sum = sum + cellvalue;

			} catch (NumberFormatException e) {
				System.err.println("Invalid Integer Format : " + text);
			}
		}

			System.out.println("Sum of Total Items in the cart " + sum);
			String text = driver.findElement(By.xpath("//span[@class='totAmt']")).getText();
			int totAmt = Integer.parseInt(text);
			System.out.println(totAmt);
			Assert.assertEquals(totAmt, sum);
			System.out.println("totAmt is matching with sumAmount");
		}
	
    @Test
	public void applyPromoCode() throws InterruptedException {
    	selectAddToCart();
		itemsinCart();
		
		//Test case 2 - Apply code and verify the discounted price and verify the amount after discounted
    	
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		String textForCodeApplied = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		System.out.println(textForCodeApplied);

		String discount = driver.findElement(By.xpath("//span[@class='discountPerc']")).getText();
		//int discountedValue = Integer.parseInt(discount);
		System.out.println(discount);
		String[] parts = discount.split("%"); 
		String numericValue = parts[0];
		
		System.out.println("Numeric Value after Split:" +numericValue);
		
		

		//Assert.assertTrue(discountedValue, "Discount is applied");
		String discountedAmt= driver.findElement(By.xpath("//span[@class='discountAmt']")).getText();
		double finalAmt = Double.parseDouble(discountedAmt);
		System.out.println(finalAmt);
		
	}

	
@AfterMethod
public void closeBrowser() {
	driver.quit();
	
}
}
