//WORKING WITH STREAMS

//1. here we go t an online cart, sort out the vegetable/fruit list,
//2. we then search for an item that is not on the first page, and pull out the price for it
//moving from one page to another is called PAGINATION

package beregression;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest55 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//STEP 1 - loading the web page
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		

		//step 2 - locating the vegetables list header, and clicking on it to get the sorted vegetables list
		WebElement vegHeaderArrow = driver.findElement(By.xpath("//tr/th[1]"));
		vegHeaderArrow.click();
		
		
		//STEP 3 - here we try to find RICE in the vegetable/fruit list that we get on the first page
		//if not found, we move to next page, we continue doing this till RICE is found
		//we use do-while loop here, we try to find Rice from the items list on the first page, and invoke getPrice method if found (DO)
		//otherwise we go and click on Next button if we fail to find Rice (WHILE)
		//we use if statement inside DO so as to click on next button if the priceRice string has no elements
		//while statement moves the operation back to do statement when priceRice string contains no elements
		//here we declare priceRice variable before initiating the do while loop, so that it could be accessed within the loop
		
		List<String> priceRice;
		
		do {
			List<WebElement> originalVegList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			
			priceRice = originalVegList.stream().filter(s->s.getText().contains("Rice"))
					.map(s->getPrice(s)).collect(Collectors.toList());
			
			priceRice.stream().forEach(p->System.out.println("Price for Rice : " + p));
			
			if(priceRice.size() < 1)
			{
				WebElement nextBtn = driver.findElement(By.xpath("//a[@role='button'][@aria-label='Last']"));
				nextBtn.click();
				Thread.sleep(1000); //added just to see the flow
			}
			
		} while(priceRice.size() < 1); //length less than 1 means go to DO statement when priceRice is empty

				
			driver.close();

	}
	
	public static String getPrice (WebElement s)
	{
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
