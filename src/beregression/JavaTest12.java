
//USING ASSERTIONS

//performing actions on a web page
// Step1 : we login to rahulshettyacademy web page
// Step2 : we verify the welcome message
// Step3 : we LOG OUT 

package beregression;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaTest12 {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		JavaTest12 uID = new JavaTest12();
		String userID = uID.inputByUser();
		
		//STEP 1 : OPENING WEB PAGE
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //adding implicitly wait
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //opening the web page
		driver.manage().window().maximize();
		String mainPageID = driver.getWindowHandle();
		
		
		//STEP 2 : LOGGING IN TO THE WEB PAGE
		WebElement username = driver.findElement(By.id("inputUsername"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		Thread.sleep(1000);
		WebElement checkBoxTerms = driver.findElement(By.id("chkboxTwo"));
		WebElement signInButton = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		
		
		//STEP 3 : INPUTTING USER CREDENTIALS, CHECKING TERMS & POLICY CHECKBOX, AND CLICKING ON SIGN IN BUTTON
		username.sendKeys(userID);
		password.sendKeys("rahulshettyacademy");
		checkBoxTerms.click();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //adding explicit wait
		
	
		System.out.println(username.getAriaRole()); //getAriaRole gets the we element type
		
		
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)); //adding explicit wait conditions to SignIn button
		signInButton.click();
		
		//STEP 4 : VERIFYING THE HOME PAGE AND ITS HEADINGS
		//here we use Assert class from TestNG to put in assertions
	    WebElement heading2 = driver.findElement(By.xpath("//div/div/div/div/h2"));
	    Assert.assertEquals(heading2.getText(), "Hello " + userID + ",");
	    
		WebElement heading1 = driver.findElement(By.cssSelector("div[class='login-container'] h1")); 
		Assert.assertEquals(heading1.getText(), "Welcome to Rahul Shetty Academy");
		
		//STEP 5: LOGGING OUT OF THE WEB PAGE
		//if we want to identify a locator with a certain text with XPATH >> //tagName[text()='text_of_the_element']
		//we can also omit tagName with * in case the element is uniquely identified even without tagName , this is applicable for all XPATH locator strategies 
		//By.xpath(//*[text()='text_of_the_element']) or By.xpath(//*[@attribute='value'])
		//in case of CSS SELECTOR we just don't put anything >> By.cssSelector([attribute='value'])
		//check if this strategy is available for CSS SELECTOR
		
		WebElement logOutBtn = driver.findElement(By.xpath("//button[text()='Log Out']"));
		wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
		logOutBtn.click();
		
		driver.close();
	
		
}
	public String inputByUser() {
		
		try(Scanner userInput = new Scanner(System.in)) {
				System.out.println("Enter your userid : ");
				String userIDInput= userInput.next();
				System.out.println("Given userid : " + userIDInput);
				return userIDInput;
			}
			
		}
}



/*
<input type="text" placeholder="Username" id="inputUsername" value="">

<input type="password" placeholder="Password" name="inputPassword" value="">

<input type="checkbox" id="chkboxTwo" name="chkboxTwo" value="agreeTerms">

<button class="submit signInBtn" type="submit">Sign In</button>


<button class="logout-btn">Log Out</button>
//button[text()='Log Out']


*/