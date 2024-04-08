//RELATIVE LOCATORS IN SELENIUM
//JavaTest58

//Relative Locators are introduced in Selenium4
//used to locate web elements that do not have unique identifiers

/*
Here's a list of locators that can be used with RelativeLocator:
	- By.id
	- By.className
	- By.tagName
	- By.name
	- By.linkText
	- By.partialLinkText
	- By.cssSelector
	- By.xpath
You can use any of these locators in combination with RelativeLocator methods 
(toLeftOf, toRightOf, above, below, near) to locate elements relative to other elements.
*/

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class JavaTest58 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		
		//1. USING ABOVE() RELATIVE LOCATOR
		//here our goal is to get the text of Name element on the web page, 
		//but as it does not have any unique identifier, we use above() relative locator with respect to Name Edit Box to locate it
		//first we locate the Name Edit Box using any locator strategy, 
		//then we use above() to locate Name element
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@class='form-control ng-untouched ng-pristine ng-invalid']"));
		WebElement nameLabel = driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox));
		System.out.println(nameLabel.getText());
		System.out.println("\n");
		
	
		
		//2. NOW WE USE BELOW() RELATIVE LOCATOR FOR SUBMIT BUTTON OF THE WEB FORM
		//here we first locate DOB Edit Box and then give its reference to locate Submit button
		
		WebElement dobEditBox = driver.findElement(By.cssSelector("input[class='form-control'][type='date']"));
		dobEditBox.sendKeys("06/08/1988");
		
		WebElement submitBtn = driver.findElement(RelativeLocator.with(By.className("btn-success")).below(dobEditBox));
		submitBtn.click();
		Thread.sleep(10000);
		
		WebElement submitAlert = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
		System.out.println("Submit Button Alert : " + submitAlert.getText());
		System.out.println("\n");
		
		
		//3. USING LEFTOF() RELATIVE LOCATOR 
		//now we click on the checkbox left of its message
		WebElement loveICmsg = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		WebElement loveICcheckBox = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(loveICmsg));
		loveICcheckBox.click();
		Thread.sleep(1000);
		
				
		//4. USING RIGHTOF() RELATIVE LOCATOR 
		
		WebElement studentRB = driver.findElement(By.id("inlineRadio1"));
		WebElement employedRB = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(studentRB));
		employedRB.click();
		Thread.sleep(1000);
		
		driver.close();
		
	}

}

