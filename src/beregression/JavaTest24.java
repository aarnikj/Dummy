//HANDLING DYNAMIC DROP DOWNS

//the items/values in a dynamic drop down are loaded/appear based upon user actions

//here we will be locating the element in the second dynamic drop down using INDEX since it is contains similar values as the first drop down

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest24 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//here the TO drop down gets loaded only after we select a city in FROM drop down
		
		WebElement fromDDarrow = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")); //locating FROM drop down arrow 
		fromDDarrow.click(); //clicking the arrow on FROM drop down
		WebElement fromOptionBLR = driver.findElement(By.xpath("//a[@value='BLR']")); 
		fromOptionBLR.click(); //selecting BLR city
		
		//WebElement toDDarrow = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")); //we need need find this drop down since its opening as soon as we click a city in FROM DD
		
		WebElement toOptionDEL = driver.findElement(By.xpath("(//a[@value='DEL'])[2]")); //USING INDEX TO LOCATE A CITY IN THE TO DROP DOWN
		toOptionDEL.click(); //selecting DEL city
		Thread.sleep(2000);
		
	
		/*
		 the page has two options for city in each drop down, and as selenium start scanning for the web element from top left, we should not be worried out the options in FROM DD as it is the first DD
		 but the cities in TO DD are second entries, so we should use indexes to locate the element
		 */
		
		
		driver.close();
	
	}

}


/*
<span id="ctl00_mainContent_ddl_originStation1_CTXTaction" class="red-arrow-btn"></span>

<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bengaluru (BLR)" value="BLR"> Bengaluru (BLR)</a>
//a[text()='Bengaluru (BLR)']


<span id="ctl00_mainContent_ddl_destinationStation1_CTXTaction" class="red-arrow-btn"></span>


<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Delhi (DEL)" value="DEL"> Delhi (DEL)</a>

<input id="ctl00_mainContent_ddl_originStation1_CTXT" name="ctl00_mainContent_ddl_originStation1_CTXT" selectedtext="Bengaluru (BLR)" selectedvalue="BLR" value="Bengaluru (BLR)" class="select_CTXT valid" menuselection="true" autocomplete="off" style="width: 250px; height: 43px; border: 1px solid rgb(153, 153, 153);">
*/