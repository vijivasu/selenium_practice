

package testNGLearning;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelUsingDataProvider {
	
	String s1="str";
	String s2=s1;
	WebDriver driver;
	
	@DataProvider(name="fetchData")
	
	public Object[][] readExcel()
	{
		Object[][] data = null;
		try
		{
			data= getDataFromExcel(System.getProperty("user.dir")+"/excel/testdata.xlsx", "topicstolearn");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return data;
	}

	private Object[][] getDataFromExcel(String path, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		Object[][] excelData= null;
		XSSFWorkbook wb = null;
		
		try
		{
			wb = new XSSFWorkbook(path);
			XSSFSheet sheet= wb.getSheet(sheetName);
			int noOfRows= sheet.getPhysicalNumberOfRows(); // no of rows
			XSSFRow row =sheet.getRow(0);
			int noOfCols= row.getPhysicalNumberOfCells(); //no of columns
			
			excelData= new Object[noOfRows-1][noOfCols];
			
			for(int i=1; i<noOfRows;i++)
			{
				for(int j=0;j<noOfCols;j++)
				{
					String cellValue= sheet.getRow(i).getCell(j).getStringCellValue();
					excelData[i-1][j]=cellValue;
					//[0][0]= selenium
					//[0][1]=guru99
					//[1][0]=java
					//[1][1]=geekforgeeks
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			wb.close();
		}
		
		
		return excelData;
	}
	
	@Test(dataProvider="fetchData")
	public void displayExcelValues(String topic, String website)
	{
		driver = new ChromeDriver();
		driver.get("https://google.com");
		WebElement searchvalue = driver.findElement(By.name("q"));
		searchvalue.sendKeys(topic +" "+ website);
		
		Assert.assertTrue(searchvalue.getAttribute("value").equalsIgnoreCase(topic +" "+ website));
		System.out.println("Assert Passed");
		
		
		
	}

}
