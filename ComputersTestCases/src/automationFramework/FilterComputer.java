package automationFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FilterComputer extends TestCaseBase {
  @Test
  public void main() {

		filterByName(Constants.Computer_1); // Filter on the computer name
		
		int namePos = checkIfNameExists(Constants.Computer_1); // Check if the name exist
		
		assertNotEquals(namePos, 0); // Will mark the test case as failure if the name doesn't exist
		
		int introducedPos = namePos +1; // Introduced Date Position in the table
		int discontinuedPos = namePos +2; // Discontinued Date Position in the table
		int companyPos = namePos + 3; // Company Position in the table
		
		// Make sure of the Introduced Date of the selected computer
		assertEquals(driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td["+introducedPos+"]")).getText(), Constants.Introduced_Formatted_1);
		
		// Make sure of the Discontinued Date of the selected computer
		assertEquals(driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td["+discontinuedPos+"]")).getText(), Constants.Discontinued_Formatted_1);
		
		// Make sure of the Company of the selected computer
		assertEquals(driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr["+namePos+"]/td["+companyPos+"]")).getText(), Constants.RCA_TEXT);
  }
}
