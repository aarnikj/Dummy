//EXTRACTING TEXT STRING FROM A WEB ELEMENT AND DYNAMICALLY SENDING IT TO A ANOTHER WEB ELEMENT - this is one way of writing this code

//here we would extract the temporary password (rahulshettyacademy) after clicking the RESET LOGIN BUTTON
// and then login with the extracted password value

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaTest13 {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //opening the web page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		JavaTest13 systemGeneratedPassword = new JavaTest13();
		String userpassword = systemGeneratedPassword.tempPassword();
		
		
		WebElement goToLoginBtn = driver.findElement(By.xpath("//form/div/button[@class='go-to-login-btn']"));
		WebElement username = driver.findElement(By.id("inputUsername"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		WebElement checkBoxTerms = driver.findElement(By.id("chkboxTwo"));
		WebElement signInButton = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(goToLoginBtn));
		goToLoginBtn.click();
		
		username.sendKeys("abhajoshi");
		password.sendKeys(userpassword);
		Thread.sleep(1000);
		
		wait1.until(ExpectedConditions.elementToBeClickable(checkBoxTerms));
		checkBoxTerms.click();
		Thread.sleep(1000);
		
		wait1.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
		
		boolean heading1Text = wait1.until(ExpectedConditions.textToBePresentInElementLocated((By.cssSelector("div[class='login-container'] h1")), "Welcome to Rahul Shetty Academy"));
	
		System.out.println("is login Page heading 'Welcome to Rahul Shetty Academy' : " + heading1Text);
		
		Assert.assertEquals(true, true);
		
		
		driver.close();
	}
	
	//CREATING A SEPARATE METHOD TO EXTRACT TEMPORARY PASSWORD
	
	public String tempPassword() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //opening the web page
		WebElement forgotPassword = driver.findElement(By.xpath("//a[text()='Forgot your password?']"));
		forgotPassword.click();
		
		WebElement resetBtn = driver.findElement(By.cssSelector(".reset-pwd-btn"));
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(resetBtn));
		resetBtn.click();
		Thread.sleep(1000);
		
		WebElement tempPasswordMsg = driver.findElement(By.cssSelector("form p"));
		String passwordMsg = tempPasswordMsg.getText();
		String[] arrPassMsg1 = passwordMsg.split("'");
		
		
		/*
		 after we split the text string, an array will be generated
		 arrPassMsg1[0] = Please use temporary password 
		 arrPassMsg1[1] = rahulshettyacademy' to Login.
		 
		 We now have to split  arrPassMsg1[1] again, the following array values will be generated
		 arrPassMsg2[1] = rahulshettyacademyto
		 arrPassMsg2[1] = to Login.
		 */
		
		String[] arrPassMsg2 = arrPassMsg1[1].split("'"); 
				
		String tempPassword = arrPassMsg2[0]; //storing rahulshettyacademy in a variable
		
		//String tempPassword =  arrPassMsg1[1].split("'")[0]; //can also be written like this
		
		return tempPassword;
	}

}

/*
<a href="#">Forgot your password?</a>
//a[text()='Forgot your password?']

<button class="reset-pwd-btn">Reset Login</button>
.reset-pwd-btn

<p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
form p

<button class="go-to-login-btn">Go to Login</button>

*/