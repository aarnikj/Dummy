//WORKING WITH CALENDARS

//here we select the current date in the calendar after selecting from and to cities

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaTest29 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement fromDDarrow = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction"));
		fromDDarrow.click();
		WebElement blrCity = driver.findElement(By.xpath("//a[@value='BLR']"));
		blrCity.click();
		Thread.sleep(1000);
		
		WebElement jaipurCity = driver.findElement(By.xpath("(//a[@value='JAI'])[2]"));
		jaipurCity.click();
		
		WebElement currentDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
		currentDate.click();
	
		driver.close();
		

		
       
	}

}
