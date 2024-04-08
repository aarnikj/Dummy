//HANDLING DYNAMIC DROP DOWNS

//the items/values in a dynamic drop down are loaded/appear based upon user actions.

//here we will be locating the element in the second dynamic drop down using PRENT CHILD RELATIONSHIP since it is contains similar values as the first drop down

//parent child relationship is different from parent child traverse

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest25 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// here the TO drop down gets loaded only after we select a city in FROM drop
		// down

		WebElement fromDDarrow = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")); // locating
																												// FROM
																												// drop
																												// down
																												// arrow
		fromDDarrow.click(); // clicking the arrow on FROM drop down
		Thread.sleep(1000);
		WebElement fromOptionBLR = driver.findElement(By.xpath("//a[@value='BLR']"));
		fromOptionBLR.click(); // selecting BLR city

		// WebElement toOptionDEL =
		// driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']
		// //a[@value='DEL']"));

		WebElement toOptionDEL = driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']"));

		// USING PARENT CHILD RELATIONSHIP TO LOCATE A CITY IN THE TO DROP DOWN
		// XPATH > parent_xpath <space> child_xpath
		// here parent is the whole drop down
		toOptionDEL.click(); // selecting DEL city
		Thread.sleep(2000);

		driver.close();

	}

}

/*
 * 
 * /html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[
 * 3]/div/div[2]/div[2]
 */
