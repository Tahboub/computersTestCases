package automationFramework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.By;

public class DeleteComputer extends TestCaseBase {
  @Test
  public void main() {
	  
		filterByName(Constants.Computer_2); // Filter on the computer name
		
		int namePos = checkIfNameExists(Constants.Computer_2); // Make sure the computer exists in the table
		assertNotEquals(namePos, 0); // Will mark the test case as failure if the name doesn't exist

		// Get the href from the computer name and navigate to it
		String url = driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td[1]/a")).getAttribute("href");
		driver.navigate().to(url);
	  
		driver.findElement(By.cssSelector(".danger")).click(); // Delete the computer from the database
		
		// Make sure the warning message appeared correctly
		assertEquals(driver.findElement(By.cssSelector(".warning")).getText(), "Done! Computer has been deleted");
  }

}
