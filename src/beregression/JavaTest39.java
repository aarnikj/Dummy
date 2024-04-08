// COMPLEX EXAMPLE - WORKING ON CALENDAR

//RESOLVE THIS CODE

//JavaTest39
//here we go to a travel web site and select the desired travel date on the calendar


package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaTest39 {
	static String expectedDay = "30";
	static String expectedMonth = "May 2024";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companion/");
		
		Actions a = new Actions(driver);
		//locating the calendar web element and clicking on it
		WebElement travelDateCalendar = driver.findElement(By.id("form-field-travel_comp_date"));//
		a.moveToElement(travelDateCalendar).click().build().perform();
		Thread.sleep(1000);
		
		WebElement monthPicker = driver.findElement(By.className("flatpickr-month")); //locating the month picker
		String actualMonth = monthPicker.getText();
		System.out.println(actualMonth);
		
		
		//we now use while loop to keep clicking on the next button in monthPicker till it finds the expectedMonth
		while(!(driver.findElement(By.className("flatpickr-month")).getText()).contains(expectedMonth)) //here while loop becomes true when the actualMonth does not match expectedMonth
		{
			a.moveToElement(driver.findElement(By.xpath("//div[@class='flatpickr-month']/span[@class='flatpickr-next-month']"))).click().build().perform();
			
		}
		String selectedMonth = driver.findElement(By.className("flatpickr-month")).getText();
		System.out.println("Selected Month : " + selectedMonth);
		
		//locating all the days in the calendar
		List<WebElement> calendarDays = driver.findElements(By.xpath("//span[starts-with(@class,'flatpickr-day')]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(travelDateCalendar));
		
		for(int i=0; i<calendarDays.size(); i++) //iterating through the calendar days to find the expectedDay
		{
			String actualDay = driver.findElements(By.xpath("///span[starts-with(@class,'flatpickr-day')]")).get(i).getText(); //getting the actualDay value
			if(actualDay.equalsIgnoreCase("30")) //comparing it with the expectedDay value
			{
				driver.findElements(By.cssSelector("span[class^='flatpickr-day']")).get(i).click(); //clicking on the day if it equals the expectedDay
																									//another way of locating the calendar days
				break; //breaking out of the loop once the match is found
			}
			Thread.sleep(1000);
		}
		
		driver.quit();
		
	}
}

/*

<input type="text" name="form_fields[travel_comp_date]" id="form-field-travel_comp_date" class="elementor-field elementor-size-sm elementor-field-textual elementor-date-field flatpickr-input" placeholder="Date of travel" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" readonly="readonly">

*/