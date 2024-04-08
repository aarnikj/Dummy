// USING LOCATOR STRATEGiES

//here we are using rahulshettyacademy web site
// we have to first try to login to the web page using wrong password
// we then click on Forgot Password
// we reset the password
// we enter the correct user details
// we click on SignIn button

//these scripts have thread.sleep(millisec) added just to show the flow of the code, in real time we don't use it
//implicit wait and explicit wait is used instead


package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaTest11 {
	
	static String expectedSignInError = "* Incorrect username or password";
	static String expectedResetLoginMessage = "Please use temporary password 'rahulshettyacademy' to Login.";
	static String expectedPageTitle = "Rahul Shetty Academy - Login page";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //adding implicitly wait
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //opening the web page
		String mainPageID = driver.getWindowHandle(); //getting main page ID
		driver.manage().window().maximize(); //maximizing the window
		Thread.sleep(1000); 
		
		
		System.out.println("Main Page ID is : " + mainPageID); //just printing the main page ID
		System.out.println("\n");
		
		WebElement userName = driver.findElement(By.id("inputUsername"));
		WebElement password = driver.findElement(By.name("inputPassword"));
		WebElement signInButton = driver.findElement(By.className("signInBtn"));
		//the sign in button has two classes: submit & signInBtn, using one of them
		
		//adding explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
		
		//sending input values
		userName.sendKeys("abhajoshi");
		password.sendKeys("rahulshetty123"); //giving wrong password
		signInButton.click();
		Thread.sleep(1000);
		
		
		//USING CSS SELECTOR LOCATOR TO LOCATE THE ERROR MESSAGE
		//for id locator, CSS selector >> #id >> only applicable for id locator
		// if we have className locator available, then CSS selector >> .className
		//another strategy, if the className attribute has spaces we can remove the space and replace it with dot symbol (for CSS locator)
		// tagname.className works when a web element have multiple class names, or have classes with the same name)
		// for className locator >> .className would also work
		//if there is no className or id locator, CSS selector >> tagName[attribute1='value1']….[attributeN='valueN']
		WebElement signInError = driver.findElement(By.cssSelector("p.error"));
		Thread.sleep(1000);
		
		String actualSignInError = signInError.getText(); //capturing error text
		System.out.println("Error message : " + actualSignInError);
		System.out.println("\n");
		
		if(expectedSignInError.equals(actualSignInError))
		{
			System.out.println("TCID09 - sign in error message is pass");
			
		}
		else 
		{
			System.out.println("TCID09 - sign in error message is fail");
		}
		System.out.println("\n");
		
		
		//LOCATING FORGOT YOUR PASSWORD
		//tag <a> stands for anchor and it represents a hyperlink element
		//to use LINK TEXT locator strategy we should make sure that the corresponding element has <a> tag
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?"));
		forgotPassword.click();
		
		
		
		//to construct XPATH for ant html property >> //tagName[@attribute1='value1']...[@attributeN='valueN']
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.sendKeys("abhajoshi");
		
		//entering and clearing value from text/edit box
		WebElement email = driver.findElement(By.cssSelector("input[placeholder='Email']")); //using customized CSS path
		email.sendKeys("abhajoshiab@gmail.com");
		Thread.sleep(1000);
		email.clear(); //clearing the value
		Thread.sleep(1000);
		email.sendKeys("abhajoshiabha@gmail.com");
		
		//in case we are unable to find unique values for a web element, we can use INDEXING to specify the element number on the web page
		//indexing should be the last thing to try for locating a web element
		//XPATH >> tagName[@attribute='value'][index]
		//CSS SELECTOR >> tagName[attribute='value']:nth-child(index)
		//WebElement phoneNum = driver.findElement(By.cssSelector("input[type='text']:nth-child(4)"))
		WebElement phoneNum = driver.findElement(By.xpath("//input[@type='text'][3]"));
		phoneNum.sendKeys("919282982906");
		Thread.sleep(1000);
		
		//NOTE: Sometimes XPATH and CSS have different index numbers may change for XPath and CSS.
		//It's because there could be some hidden type equals to text on this HTML web page
		//There could be some hidden attribute on this type text where XPath will ignore that hidden attribute.
		//But CSS counts that hidden attribute.


		//traversing an element using TAGS
		//XPATH >> //parenttagName/childtagName
		// in case of multiple elements with the same child tag, XPATH >> //parenttagName/childtagName[index]
		//CSS Selector >> parenttagName childtagName
		WebElement fpHeading = driver.findElement(By.xpath("//form/h2")); //here double slash represents a parent tag occurrence and single slash represents a child tag occurrence
		String fpPageHeading = fpHeading.getText();
		System.out.println("Forgot Password Page Heading is : " + fpPageHeading);
		System.out.println("\n");
		
		WebElement emailID = driver.findElement(By.xpath("//form/input[2]")); //using indexing in tagName locator : XPATH
		String eID = emailID.getAccessibleName();
		System.out.println("Accessible name Text for email id field : " + eID);
		System.out.println("\n");
		
		WebElement goToLoginBtn = driver.findElement(By.cssSelector("form div button:nth-child(1)")); //using indexing in tagName locator : CSS SELECTOR
		String goToLogin = goToLoginBtn.getAccessibleName(); //getAccessibleName() method gives the accessible name of the web element
        System.out.println("Go TO LOGIN button accessible name is : " + goToLogin);
        System.out.println("\n");
		
		
		//CLICKING ON RESET LOGIN BUTTON
		WebElement resetLoginBtn = driver.findElement(By.cssSelector("form div button:nth-child(2)"));
		wait.until(ExpectedConditions.elementToBeClickable(resetLoginBtn));
		resetLoginBtn.click();
		Thread.sleep(1000);
		
		WebElement resetLoginMsg = driver.findElement(By.cssSelector("p.infoMsg"));
		String actualResetLoginMessage = resetLoginMsg.getText();
		System.out.println("Reset Login Message is : " + actualResetLoginMessage);
		System.out.println("\n");
		
		Thread.sleep(1000);
	
		if(expectedResetLoginMessage.equals(actualResetLoginMessage))
		{
			System.out.println("TCID10 - password reset message display is pass");
		}
		else
		{
			System.out.println("TCID10 - password reset message display is fail");
		}
		
		System.out.println("\n");
		
		
		//NOW WE GO BACK TO THE LOGIN PAGE
		WebElement goToLoginButton = driver.findElement(By.cssSelector(".go-to-login-btn"));//using another way to locate the element
		goToLoginButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToLoginButton));
		
		
		//sending input values
		userName.sendKeys("abhajoshi");
		password.sendKeys("rahulshettyacademy"); //this time using the right password
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
		signInButton.click();
		
		
		String actualPageTitle = driver.getTitle(); //getting title of the web page
		System.out.println("Page Title is  : " + actualPageTitle);
		Thread.sleep(2000);
		System.out.println("\n");
		
		if(expectedPageTitle.equals(actualPageTitle))
		{
			System.out.println("TCID11 - login to web page is pass");
		}
		else
		{
			System.out.println("TCID11 - login to web page is fail");
		}
		
		
		
		driver.close(); //using close() method because due to the web page design everything above is happening within the same browser window
	}

}


/*
 <input type="text" placeholder="Username" id="inputUsername" value="">
 
<input type="password" placeholder="Password" name="inputPassword" value="">

<button class="submit signInBtn" type="submit">Sign In</button>

/html/body/div/div/div/div/div/div/div[2]/form/p
 
 <p class="error">* Incorrect username or password </p>
 
  <a href="#">Forgot your password?</a>
  
  <input type="text" placeholder="Name">
  
  <input type="text" placeholder="Email">
  
  <button class="reset-pwd-btn">Reset Login</button>
  
  <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
  
  <button class="go-to-login-btn">Go to Login</button>
  
  <title>Rahul Shetty Academy - Login page</title>
 
/
*/
