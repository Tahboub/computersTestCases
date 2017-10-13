package automationFramework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import automationFramework.Constants;

public class NewComputer extends TestCaseBase {


	@Test
	public void main() throws InterruptedException {
		driver.findElement(By.id("add")).click(); // Click on Create New Computer
		
		driver.findElement(By.id("name")).sendKeys(Constants.Computer_1); // Fill Computer Name
		
		driver.findElement(By.id("introduced")).sendKeys(Constants.Introduced_Date_1); // Fill Introduced Date
		
		driver.findElement(By.id("discontinued")).sendKeys(Constants.Discontinued_Date_1); // Fill Discontinued Date
		
		WebElement element = driver.findElement(By.id("company")); // Select a Company
		Select cSelect = new Select(element);
		cSelect.selectByValue(Constants.RCA_VALUE);
		driver.findElement(By.cssSelector(".primary")).click(); // Click on Create This Computer

		Thread.sleep(1000); // Make sure the new page is loaded

		// Make sure the warning message appeared correctly
		assertEquals(driver.findElement(By.cssSelector(".warning")).getText(), "Done! Computer " + Constants.Computer_1 + " has been created");
	}

}
