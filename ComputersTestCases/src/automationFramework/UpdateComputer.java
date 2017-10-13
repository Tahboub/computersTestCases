package automationFramework;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdateComputer extends TestCaseBase {
	@Test
	public void main() {
		
		filterByName(Constants.Computer_1); // Filter on the name of the computer
		
		int namePos = checkIfNameExists(Constants.Computer_1); // Check if the computer name exists in the table
		assertNotEquals(namePos, 0); // Will mark the test case as failure if the name doesn't exist

		// Get the href from the computer name and navigate to it
		String url = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td[1]/a")).getAttribute("href");
		driver.navigate().to(url);
		
		driver.findElement(By.id("name")).clear(); // Clear the computer name
		driver.findElement(By.id("name")).sendKeys(Constants.Computer_2); // Fill the updated Computer Name
		
		driver.findElement(By.id("introduced")).clear(); // Clear the introduced date
		driver.findElement(By.id("introduced")).sendKeys(Constants.Introduced_Date_2); // Fill the updated Introduced Date
		
		driver.findElement(By.id("discontinued")).clear(); // Clear the discontinued date
		driver.findElement(By.id("discontinued")).sendKeys(Constants.Discontinued_Date_2); // Fill the updated Discontinued Date
		
		WebElement element = driver.findElement(By.id("company")); // Select the updated Company
		Select cSelect = new Select(element);
		cSelect.selectByValue(Constants.APPLE_VALUE);
		driver.findElement(By.cssSelector(".primary")).click(); // Click on Update This Computer
		
		// Make sure the warning message appeared correctly
		assertEquals(driver.findElement(By.cssSelector(".warning")).getText(), "Done! Computer " + Constants.Computer_2 + " has been updated");
	}

}
