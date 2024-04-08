//COMPLEX EXAMPLE - working with page hyper links

//here we go to a web page and do the following:
//1.count the number of hyper links in the page
//2.count the number of hyper links in footer section
//3.count the number of links in the first column of the footer section
//4. we open all the hyper links of footer column one at once
//5. we finally validate if the pages are open by extracting their page titles

package beregression;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest38 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. counting number of hyper links in the page
		List<WebElement> pageLinks = driver.findElements(By.tagName("a")); //all links will have tag <a>
		System.out.println("Total Links in the page " + pageLinks.size());
		System.out.println("\n");
		
		//2. counting the number of hyper links only on the footer section of the page
		//here we are limiting the web driver scope by locating the entire section and passing it as a web driver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //here we first locate the footer section and then find hyper linked web elements within it
		List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a")); 
		System.out.println("Total Footer Links : " +  footerLinks.size());
		System.out.println("\n");
		
		//3. counting the number of hyper links in the first column of the footer section
		//here we can start locating the first column of the footer section using footerDriver since we already have the path till there
		WebElement footerFirstColDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		List<WebElement> footerFirstColLinks = footerFirstColDriver.findElements(By.tagName("a"));
		Thread.sleep(2000);
		System.out.println("Total First Column Links : " + footerFirstColLinks.size());
		System.out.println("\n");
		
		
		
		//4. we open all the hyper links of footer column one in separate windows at once
		//since the first hyper link in the first column is a dead link, we ignore it and start our counter from 1
		for(int i=1; i<footerFirstColLinks.size(); i++)
		{
			//String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);//Keys. chord() method helps to press multiple keys simultaneously
																	// as a general practice, we use CTRL+ENTER/CLICK or CMD+ENTER/CLICK if we want to open a web page hyperlink on a separate window
																	//ENTER key can be used to perform CLICK action
			String clickOnLink = Keys.chord(Keys.COMMAND,Keys.ENTER);
			
			footerFirstColDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);  //here we get the index of each hyper link and then send clickOnLink keyboard action to it
																// whenever there is a keyboard event, we have to pass them both as a sendKeys method.		
			Keys.chord(Keys.COMMAND,Keys.ENTER);
			Thread.sleep(3000);
			
		}
		
		//5. finally validate if the pages are open by extracting their page titles
		
		Set<String> windows = driver.getWindowHandles(); //here we would be first getting all the window handles (window handle is extracted for the open web page)
														 // getWindowHandles() method returns a set of strings
		Iterator<String> itWin = windows.iterator(); //now we use the iterator method to return an iterator over the element in windows as an iterator of strings
													// we have to import java.util.Iterator package to to use iterator object
		
		//now we use while loop to iterate through the iterator
		while(itWin.hasNext()) //the while loop continues to iterate as long as it find a next value in the iterator
		{
			driver.switchTo().window(itWin.next()); //here we change the web driver context to the next value in the iterator (i.e the next window)
			System.out.println("Page Title: " + driver.getTitle());
			System.out.println("\n");
		}
		
		//hasNext() is different from next()
		//hasNext() returns true if the object has next value
		//next() returns the next value
		
		driver.quit();
	}

}
