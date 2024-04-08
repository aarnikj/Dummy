//COMPLEX EXAMPLE - PERFORM BROWSER/WINDOW LEVEL SCROLLING  AND A TABLE (WEB ELEMENT) LEVEL SCROLLING USING JAVASCRIPT EXECUTOR

//this comes handy when the web browser has certain objects with hidden elements
// or when we want to execute a headless browser test (that means no opening of the web browser by the web driver)

//Selenium does not provide any scrolling techniques so we should execute JavaScript.
//javascript executor leverages the web driver to be able to perform the javascript related tasks. All the web browsers are made on JavaScript, 

//JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. 
//JavaScriptExecutor provides two methods “executescript” & “executeAsyncScript” to run javascript on the selected window or current page.

//more details: https://www.guru99.com/execute-javascript-selenium-webdriver.html


//1. here we go to a web page and scroll down the page to bring a table of interest in focus
//2. we then scroll to top in the table
//3. we then extract the amount values in fourth column of the table and do their sum
//4. we then validate the amount sum we got with the sum displayed below the table

package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaTest40 {
	static int expectedAmtCollected = 296;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. here we go to a web page and scroll down the page to bring a table of interest in focus
		//here we create an object using JavascriptExecutor and cast the web driver to it, which leverges the web driver to perform javascript tasks
		//we have to import org.openqa.selenium.JavascriptExecutor package to be able to execute Javascripts
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		//2. we then scroll to top in the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500"); //here we locate the table using javascript
		Thread.sleep(2000);																			//we first call the DOM object, and then call querySelector method to locate the element
																					//we have to pass the CSS locator value inside query selector to locate the element
																					//scrollTop function moves the rows up, and thescroll bar down
																					//scrollTop is used for vertical scroll
																					//scrollLeft is used for horizontal scroll
		
		//3. we then extract the amount values in fourth column of the table and do their sum
		List<WebElement> amountCollected = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)")); //locating all elements of 4th column
		
		int sumOfAmounts = 0;//declaring & initializing initial sum variable
		
		System.out.println("The amounts collected are : ");
		for(int i=0; i<amountCollected.size(); i++)
		{
			int amounts = Integer.parseInt(amountCollected.get(i).getText()); //Integer.parseInt converts a String value to integer value
			System.out.println(amounts);
			sumOfAmounts = sumOfAmounts + amounts;
		}
		
		System.out.println("Total sum of amounts collected : " + sumOfAmounts);
		
		
		//4. we then validate the amount sum we got with the sum displayed below the table
		WebElement totalAmount = driver.findElement(By.cssSelector(".totalAmount"));
		int actualAmtCollected = Integer.parseInt(totalAmount.getText().split(":")[1].trim()); //fetching the amount value and converting it to integer
		
		Assert.assertEquals(actualAmtCollected, expectedAmtCollected, "The actualAmtCollected is not equal to the expectedAmtCollected");
		//putting assertion to verify the result
		
		driver.close();

		
		}

		
	}


