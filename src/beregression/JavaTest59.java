//INVOKING MULTIPLE WINDOWS/TABS USING SELENIUM

//this feature was introduced in Selenium4
//it helps us to open a web page in new window/tab

//in this example we go to a web page, pick up the first course name and put it in Name Edit Box on an another web page

package beregression;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest59 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//STEP 1 - LOADING THE MAIN PAGE WINDOW
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		//STEP 2 - opening another web page in a new TAB
		//since the web driver's context is on the main web page, we have to switch it to a new tab to open a new tab and then to the new opened window
		
		driver.switchTo().newWindow(WindowType.TAB); //this command helps us to open a new web page window in a new tab
													//we have to provide window type here
		
		/* TO OPEN A NEW WINDOW INSTEAD OF NEW TAB
		 driver.switchTo().newWindow(WindowType.WINDOW);
		 */
		
		
		//now we will retrieve all the window handles and store them in a set of String to be able to switch to the desired window ID later
		//set requires java.util package to be imported
		Set<String> windowHandles = driver.getWindowHandles();
		
		//now we iterate through the set to extract values from the above set
		//we use an iterator for this, it requires java.util package to be imported
		Iterator<String> it = windowHandles.iterator();
		
		String mainPageID = it.next(); //next() function gives us the next value in the set
		String newTabID = it.next(); //we can keep using next() function to iterate through all the values in the set
		
		driver.switchTo().window(newTabID); //this command helps us to switch the driver to the desired web page window
											//we now switch to the window under the new Tab
		
		driver.get("https://rahulshettyacademy.com/"); //after switching the web driver's context to the new tab, we open the web page url
		Thread.sleep(5000);
		
		//STEP 3 - we now locate the first course available at the bottom of the new web page and extract its text  
		//the below steps can be combined into one
		
		WebElement courseName = driver.findElement(By.xpath("(//a[@href='https://courses.rahulshettyacademy.com/p/get-access-to-all-courses'])[2]"));
		String nameText =  courseName.getText();
		
		
		/// another way of fetching the course name at the desired location, here we catch the value at index 1 from the values returned
		//check if the below statement really works
		 //String courseName = ((WebDriver) driver.findElement(By.xpath("(//a[@href='https://courses.rahulshettyacademy.com/p/']"))).get(1).getText();
		 
		 
		
		//STEP 4 - now we switch back to the parent web page, locate the NAme Edit Box and enter the nameText there
		driver.switchTo().window(mainPageID);
		Thread.sleep(5000);
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
		nameEditBox.sendKeys(nameText);
		Thread.sleep(2000);
		
		//getAttribute("value") can be used to get the text entered in a text box of a web page
		System.out.println(nameEditBox.getAttribute("value"));
		
		driver.quit();
	}

}
