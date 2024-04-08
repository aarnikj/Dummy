//WORKING WITH STREAMS
//JavaTest53

//in this example, we go to an online shopping cart, 
//grab the vegetables list, and sort it using streams
//sort out the vegetables list by click on the column top bar and grab the list
//we then compare the two list and check if they match


package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

 class JavaTest53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//step 1 - opening the web page
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//step 2 - locating the vegetables list header, and clicking on it to get the sorted vegetables list
		WebElement vegHeaderArrow = driver.findElement(By.xpath("//tr/th[1]"));
		vegHeaderArrow.click();
		
		//step 3 - grabbing the sorted list elements obtained after step 2
		List<WebElement> originalVegList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		//Step 4 - now we get the values of the original vegetables list using stream and store them to a new list
		//we are printing the value just for our reference
		List<String> originalVegListSorted = originalVegList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("The values of the original vegetables list are : ");
		originalVegListSorted.stream().forEach(s->System.out.println(s));
		System.out.println("\n");
		
		//step 4 - now we sort the original vegetables list from step 3 and then print its elements for our reference
		List<String> sortedVegList = originalVegList.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		System.out.println("The values of the sorted vegetables list are : ");
		sortedVegList.stream().forEach(s->System.out.println(s));
		
		
		//step 5- using Assertion is a good practice to check for test failure
		//comparing two lists using assertion
		Assert.assertTrue(originalVegListSorted.equals(sortedVegList));
		
		
		//to check if our code is really working, we can create a toggle breakpoint after we click on the vegetable list header, 
		//run the code on debugging mode
		//go to the web page and click the vegetable header again and then resume our test
		//the test should fail in this case, since the order of the sorted list would be messed up on clicking the vegetable list header again
		
		//driver.close();
	}
	
}