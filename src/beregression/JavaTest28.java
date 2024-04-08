//HANDLING CHECKKBOX - inserting Assertions

//here we select a check box

//we also display the number of check boxes available on the web page

package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaTest28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement studentChkbx = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
		Assert.assertFalse(studentChkbx.isSelected()); //assertFalse() should return false for the test to pass

		studentChkbx.click();
		Assert.assertTrue(true); //assertTrue() should return true for the test to pass
		
		
		//finding number of check boxes 
		//for this we have to generate a common locator path to extract all the checkboxes
		List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		Assert.assertEquals(checkBox.size(), 6, "The web page has 6 checkboxes"); //using assertion to verify number of checkboxes
		                                                                          //the message is thrown when the assertion returns false
	
		
		driver.close();


	}

}
