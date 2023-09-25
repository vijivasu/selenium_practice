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
	}
	@Test
	public void findDiscountedPercentage() throws InterruptedException {
		
		clickOnTopDeals();
		
		WebElement topDealsTable = driver.findElement(By.xpath("//table[@class='table table-bordered']"));
		
		//get all rows from the table
		List<WebElement> noOfRows = topDealsTable.findElements(By.tagName("tr"));
		System.out.println(noOfRows.size());
		List<WebElement> noOfColumns = topDealsTable.findElements(By.tagName("thead"));
		System.out.println(noOfColumns.size());
		//Iterate through the rows
		for(WebElement row:noOfRows) {
			List<WebElement> columns = driver.findElements(By.tagName("td"));
				String priceVal = columns.get(1).getText();
				String discountPrice = columns.get(2).getText();
				System.out.println("Price Values are" + priceVal);
				System.out.println("Discounted price values are " +discountPrice);
				
			}
		}
		
		
		
	}

List<WebElement> rows = table.findElements(By.tagName("tr"));

// Specify the column indices you want to extract (0-based)
int firstColumnIndex = 0;
int secondColumnIndex = 1;

// Iterate through the rows
for (WebElement row : rows) {
    // Get the columns for each row
    List<WebElement> columns = row.findElements(By.tagName("td"));

    // Check if the columns list contains the specified indices
    if (columns.size() > secondColumnIndex) {
        String firstColumnValue = columns.get(firstColumnIndex).getText();
        String secondColumnValue = columns.get(secondColumnIndex).getText();

        // Process the values as needed
        System.out.println("First column value: " + firstColumnValue);
        System.out.println("Second column value: " + secondColumnValue);
    }
}

// Close the WebDriver
driver.quit();
}
}
In this modified code, we specify the column indices (firstColumnIndex and secondColumnIndex) that we want to retrieve data from (0-based index). We then access the respective columns based on these indices within the loop and extract the data accordingly. Adjust the indices based on the specific columns you want to extract data from. Also, replace "path/to/chromedriver" with the actual path to your ChromeDriver executable.




User
how to retrieve list of values from different columns from the table in selenium java code
ChatGPT


To retrieve a list of values from different columns of a table in Selenium with Java, you can iterate through the rows of the table and extract the values from the desired columns into separate lists. Here's a modified example to demonstrate this:

java
Copy code
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TableDataExtraction {
public static void main(String[] args) {
// Set the path to your ChromeDriver executable
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

// Initialize WebDriver
WebDriver driver = new ChromeDriver();

// Navigate to the webpage
driver.get("http://example.com/your-page");

// Locate the table (assuming the table has an ID "myTable")
WebElement table = driver.findElement(By.id("myTable"));

// Get all rows from the table
List<WebElement> rows = table.findElements(By.tagName("tr"));

// Lists to store the values from the desired columns
List<String> firstColumnValues = new ArrayList<>();
List<String> secondColumnValues = new ArrayList<>();

// Specify the column indices you want to extract (0-based)
int firstColumnIndex = 0;
int secondColumnIndex = 1;

// Iterate through the rows
for (WebElement row : rows) {
    // Get the columns for each row
    List<WebElement> columns = row.findElements(By.tagName("td"));

    // Check if the columns list contains the specified indices
    if (columns.size() > secondColumnIndex) {
        String firstColumnValue = columns.get(firstColumnIndex).getText();
        String secondColumnValue = columns.get(secondColumnIndex).getText();

        // Add the values to the respective lists
        firstColumnValues.add(firstColumnValue);
        secondColumnValues.add(secondColumnValue);
    }
}

// Print the values from the desired columns
System.out.println("Values from the first column: " + firstColumnValues);
System.out.println("Values from the second column: " + secondColumnValues);

// Close the WebDriver
driver.quit();
}
}








