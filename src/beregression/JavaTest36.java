//EXAMPLE TO SHOW WINDOW HANDLES - (switching from parent window to child window) - this is one way

//here we go to a web site
//locate an element, click on it
//a new window (child window) opens
//we switching the driver context to the child window and grab the email id from it
//we switch back the driver context to the parent window and enter the email id in the username field

package beregression;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest36 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		WebElement freeMaterialLink = driver.findElement(By.cssSelector(".blinkingText"));
		freeMaterialLink.click();
		Thread.sleep(1000);
		Set<String> windowIDs = driver.getWindowHandles(); //here we extract window handles of all the open windows, it returns a set of string
		Iterator<String> it = windowIDs.iterator(); //now we create a String variable to iterate through the set of window handles to get the parent and child window handles using Iterator
											//we have to import java.util.Iterator package for this	
		
		//saving the iterator values as parent and child window ID
		String mainWinID = it.next();
		String childWinID = it.next();
		driver.switchTo().window(childWinID); //switching to child win if the iterator has a different id
		Thread.sleep(1000);
	
	
		WebElement emailMsg = driver.findElement(By.cssSelector(".im-para.red"));
		System.out.println("Message to ask for free material : " + emailMsg.getText());
		String emailID = emailMsg.getText().split("at")[1].trim().split(" ")[0].trim(); //this will take mentor@rahutshettyacademy email address from the message
																	// to inspect your code at runtime, create a toggle breakpoint, debug it, click on watc
			
		driver.switchTo().window(mainWinID);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(emailID);
		Thread.sleep(1000);
		
		driver.quit();
		
		
		
	}

}

/*
<a href="https://rahulshettyacademy.com/documents-request" class="blinkingText" target="_blank">Free Access to InterviewQues/ResumeAssistance/Material</a>

<p class="im-para red">Please email us at <strong><a href="mailto:mentor@rahulshettyacademy.com">mentor@rahulshettyacademy.com</a></strong> with below template to receive response </p>
*/