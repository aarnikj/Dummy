//RUNNING CODE ON SAFARI BROWSER

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaTest17 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new SafariDriver(); //using SAFARI driver
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); //opening the web page
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mainPageID = driver.getWindowHandle(); 
		System.out.println("Main Page ID : " + mainPageID);
		System.out.println("\n");
		
		WebElement userName = driver.findElement(By.id("inputUsername"));
		WebElement password = driver.findElement(By.name("inputPassword"));
		WebElement signInButton = driver.findElement(By.className("signInBtn"));
		
		
		//adding explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.className("signInBtn")));
		
		//sending input values
		userName.sendKeys("abhajoshi");
		password.sendKeys("rahulshettyacedemy"); //giving wrong password
		signInButton.click();
		Thread.sleep(1000);
		
		WebElement errorMsg = driver.findElement(By.xpath("//p[@class='error']"));
		
		Assert.assertEquals(errorMsg.getText(), "* Incorrect username or password");
		
		driver.close();


	}

}
