package automationFramework;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.By;


public class ViewComputer extends TestCaseBase{
	@Test
	public void main() throws InterruptedException {
		
		filterByName(Constants.Computer_1); // Filter on the computer name
		
		int namePos = checkIfNameExists(Constants.Computer_1); // Check if the name exists in the table
		assertNotEquals(namePos, 0); // Will mark the test case as failure if the name doesn't exist

		// Get the href from the computer name and navigate to it
		String url = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td[1]/a")).getAttribute("href");
		driver.navigate().to(url);

		// Make sure that the name of the computer is correct
		assertEquals(driver.findElement(By.id("name")).getAttribute("value"), Constants.Computer_1);
		
		// Make sure that the introduced date of the computer is correct
		assertEquals(driver.findElement(By.id("introduced")).getAttribute("value"), Constants.Introduced_Date_1);
		
		// Make sure that the discontinued date of the computer is correct
		assertEquals(driver.findElement(By.id("discontinued")).getAttribute("value"), Constants.Discontinued_Date_1);
		
		// Make sure that the company of the computer is correct 
		assertEquals(driver.findElement(By.id("company")).getAttribute("value"), Constants.RCA_VALUE);
	}

}
