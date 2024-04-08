//AUTOMATING BROWSER NAVIGATIONS

package beregression;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/"); //here we first open the google page
		                                       // get() method has inbuilt synchronization, so it will by default wait for google home page to load
		
		driver.navigate().to("https://mail.google.com/"); //navigate() does not have a built in synchronization mechanism, 
		Thread.sleep(1000);                           // so we will have to add wait times if we want the page to load fully
		
		driver.navigate().back(); //navigates back to previous web page
		Thread.sleep(1000);
		
		driver.navigate().forward(); //navigates forward
		Thread.sleep(1000);
		
		driver.close(); //using close() function because the code opens a single browser window		
	}

}
