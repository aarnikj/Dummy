//VERIFYING IF A WEB ELEMENT IS ENABLED/DISABLED : another way

//here we will verify if the return date is disabled when we choose one-way trip
//and enabled when we choose round trip

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest31 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement onewayRB = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
		onewayRB.click();
		Thread.sleep(1000);
		
		
		
		//another way of doing the last step if isEnabled() method is not returning any result
		//we need to check against a unique value in this case
		//return date picker path when enabled = <div id="Div1" class="picker-second" style="display: block; opacity: 1;">
		//return date picker path when enabled = <div id="Div1" class="picker-second" style="display: block; opacity: 0.5;">
		
		WebElement returnDatePicker = driver.findElement(By.cssSelector(".picker-second")); //getting the whole box for return date calendar
		System.out.println(returnDatePicker.getAttribute("style")); //added just to check
		
		if(returnDatePicker.getAttribute("style").contains("1")) //fetching on the unique value
		{
			System.out.println("Return Date Picker is enabled");
		}
		else
		{
			System.out.println("Return Date Picker is disabled");
		}
		
		System.out.println("\n");
		
		WebElement roundTripRB = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		roundTripRB.click();
		Thread.sleep(1000);
		if(returnDatePicker.getAttribute("style").contains("1")) //fetching on the unique value
		{
			System.out.println("Return Date Picker after selecting Round Trip RB is enabled");
		}
		else
		{
			System.out.println("Return Date Picker after selecting Round Trip RB is disabled");
		}
	}

}
