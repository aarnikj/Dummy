
//AN EXAMPLE TO SHOW FLUENT WAIT


package beregression;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class JavaTest34 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
		element1.click();
		Thread.sleep(1000);
		WebElement startBtn = driver.findElement(By.cssSelector("div[id='start'] button"));
		startBtn.click();
		//here we defined the fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		

		//there are no predefined methods/functions to check for the elements when using fluent wait, so we have to create our own method
		
		WebElement helloText = wait.until(new Function<WebDriver, WebElement>() {
			 public WebElement apply(WebDriver driver) {
				 if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
				 {
					 return (driver.findElement(By.xpath("//div[@id='finish']/h4")));
				 }
				 else
				 {
					 return null;
				 }
			 }
		});
		
		System.out.println("Text is : " + helloText.getText());
		
		driver.close();
		}
	}
	
	
	
		
	

	



/* Syntax for defining Fluent Wait
Sample usage:

   // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(30L))
       .pollingEvery(Duration.ofSeconds(5L))
       .ignoring(NoSuchElementException.class);

   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });
*/	

/*
<a href="/dynamic_loading/1">Example 1: Element on page that is hidden</a>

*/

