//WORKING WITH STREAMS

//here we verify that the search results return all the desired elements under vegetable/fruits list

package beregression;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaTest57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//STEP 1 - loading the web page
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//STEP 2 - locating the Search Box and inputing text into it. Here we want to look for items that start with "Ch"
		WebElement searchBox = driver.findElement(By.id("search-field"));
		searchBox.click();
		searchBox.sendKeys("Ch");
		
		//STEP 3 - now we collect the search results that are displayed
		List<WebElement> itemList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		//STEP 4 - now we traverse through the result item list to know the items it contains
		List<WebElement> searchItemList = itemList.stream().filter(veggie->veggie.getText().contains("Ch"))
				.collect(Collectors.toList());
		
		//displaying results just for reference
		System.out.println("The result items of search are :");
		searchItemList.stream().forEach(item->System.out.println(item.getText()));
		
		
		//STEP 5 - now we use Assertion to see if the two lists match
		Assert.assertEquals(itemList.size(), searchItemList.size());
		
		driver.close();
	}

}
