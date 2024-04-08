//HANDLING STATIC DROP DOWNS

// options in a static drop down are fixed
// there is a Select class in Selenium to handle drop downs with SELECT tagName 
//select drop downs are STATIC, options are always at a fixed index position

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaTest21 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement currencyDD = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currencyDDOptions = new Select(currencyDD); //Select class takes web element as input
		currencyDDOptions.selectByIndex(2); //selecting AED using selectByIndex()
		Thread.sleep(500);
		System.out.println("Third option in Currency DD is : " + currencyDDOptions.getFirstSelectedOption().getText()); //getting the first selected option
		currencyDDOptions.selectByVisibleText("INR"); //selecting by visible text INR
		Thread.sleep(500);
		System.out.println("Second option in Currency DD is : " + currencyDDOptions.getFirstSelectedOption().getText());
		currencyDDOptions.selectByValue("USD"); //selecting by text in the value attribute
		Thread.sleep(500);
		System.out.println("Fourth option in Currency DD is : " + currencyDDOptions.getFirstSelectedOption().getText());
		
		driver.close();
	}

}

/*
<select name="ctl00$mainContent$DropDownListCurrency" id="ctl00_mainContent_DropDownListCurrency" class="valid">
	<option value="">Select</option>
	<option value="INR">INR</option>
	<option value="AED">AED</option>
	<option value="USD">USD</option>

</select>


visible texts are : Select INR AED USD
value attribute has texts : Select INR AED USD

*/