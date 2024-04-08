//HANDLING AUTO SUGGESTIVE DROP DOWNS

//in this drop down, the options appear as and when user provides an input

//here our goal is to select Maldives after inputting Mal in COUNTRY DROP DOWN

package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaTest26 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement countryDD = driver.findElement(By.id("autosuggest")); //locating countryDD
		countryDD.sendKeys("Mal"); //inputing Mal
		Thread.sleep(1000);
		
		List<WebElement> countryDDoptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //locating all the elements that appear in countryDD after entering Mal 
		//we inspect Maldives and then locate its parent so as to locate the list
		//here we give a generic locator that is same for all the elements of the list
		
		for(WebElement value : countryDDoptions) //the value returned is a WebElement
		{
			if(value.getText().equalsIgnoreCase("Maldives"))
			{
				value.click();
				break;    //we insert a break statement to stop the for loop when an option is matched to the given value
			}
		}
		
		Thread.sleep(1000);
		
		
		driver.close();
		
	}
}
	


/*

<input type="text" id="autosuggest" class="inputs ui-autocomplete-input valid" placeholder="Type to Select" autocomplete="off">

<a id="ui-id-134" class="ui-corner-all" tabindex="-1">Maldives</a>

*/