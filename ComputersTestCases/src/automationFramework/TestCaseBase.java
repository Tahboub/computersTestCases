package automationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestCaseBase {

	public WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		// To run chrome driver, can be enhanced by putting the relative path or cross platform path
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://computer-database.herokuapp.com/computers"); // Go to the website
	}

	@AfterMethod
	public void afterMethod()  {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
		
		driver.quit(); // Close the browser
	}
	
	
	public int checkIfNameExists(String name) { // Method is reused by multiple test cases
		int rowValue = -1; // to make sure computer exists
		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a"));// List of Rows
		for (int i=0 ; i <  tableRows.size() ; i++){

			String sCellValue = tableRows.get(i).getText(); // Get the text of the first column value
			if(name.equalsIgnoreCase(sCellValue)){ // Check if it equals the name we're filtering on
				rowValue = i; // Put the row number in rowValue variable
				break;
			}

		}
		int namePos = rowValue +1; // Name Position, +1 because we pulled it from a list
		return namePos;
	}
	
	public void filterByName(String name) { // To filter computers by names, Method is reused by multiple test cases
		driver.findElement(By.id("searchbox")).sendKeys(name); // Put the name in the filter
		driver.findElement(By.id("searchsubmit")).click(); // Click on Filter by name button
	}
}
