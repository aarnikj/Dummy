//WORKING WITH STREAMS
//JavaTest54

//here we go to an online shopping cart,
//we scan the vegetables names, 
//we then print the price for POTATO
//here POTATO is in the first page

package beregression;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest54 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//STEP 1 - loading the web page
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		
		//step 2 - locating the vegetables list header, and clicking on it to get the sorted vegetables list
		WebElement vegHeaderArrow = driver.findElement(By.xpath("//tr/th[1]"));
		vegHeaderArrow.click();
				
		//step 3 - grabbing the sorted list elements obtained after step 2
		List<WebElement> originalVegList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		
		//Step 4 - now we get the values of the original vegetables list using stream, 
		//filter potato from the list and apply a custom method getPrice() to get the price of Potato
		//we are printing the value just for our reference
		List<String> pricePotato = originalVegList.stream().filter(s->s.getText().contains("Beans"))
				.map(s->getPrice(s)).collect(Collectors.toList());
		
		
		//Step 5 - printing the price of Potato
		pricePotato.stream().forEach(p->System.out.println("Price for Potato : " + p));
		
		
		/*
		
		//we now try to print the price for all items on the first page of the cart
		List<String> priceVeggie = originalVegList.stream().map(v->getVeggiePrices(v)).collect(Collectors.toList());
		*/
		driver.close();
	}
      
	/*
	private static String getVeggiePrices(WebDriver driver, WebElement v) {
		// TODO Auto-generated method stub
		
		List<WebElement> pricesVeg = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		return null;
	}
	*/


	//we have to match the custom method's return type to the list type that we are creating above
	//we have to pass the WebElement s as an argument to this method
	private static String getPrice(WebElement s) {
		
		//here we traverse to the sibling using the already traversed xpath for s
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
		
		
	}

}
