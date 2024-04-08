//HANDLING CHECKKBOX

//here we select a check box

//we also display the number of check boxes available on the web page

package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement studentChkbx = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
		System.out.println("Student chekbox selected before click : " + studentChkbx.isSelected());
		System.out.println("\n");
		studentChkbx.click();
		System.out.println("Student chekbox selected after click : " + studentChkbx.isSelected());
		System.out.println("\n");
		
		//finding number of check boxes 
		//for this we have to generate a common locator path to extract all the checkboxes
		List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println("Number of checkbox : " + checkBox.size());
		
		driver.close();

	}

}

/*
 <input id="ctl00_mainContent_chk_StudentDiscount" type="checkbox" name="ctl00$mainContent$chk_StudentDiscount">
 
  */
