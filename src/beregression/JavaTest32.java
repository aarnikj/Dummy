//HANDLING ALERTS

//alerts in web pages are not html coded, hence we cant handle them directly with selenium web driver
//they are javascript alerts and therefore selenium has a different way to handle them
//we have to switch the selenium webdriver context to alerts to handle them

/* TYPES OF ALERTS
 >> simple alert
- shows a message.
- it has some text and just one button


>> prompt alert
- shows a message asking the user to input text. It returns the text or, if Cancel button or Esc is clicked, null.
- has some text, an input box and two button (accept OR dismiss)


>> confirm alert
- shows a message and waits for the user to press “OK” or “Cancel”. It returns true for OK and false for Cancel/Esc.
- has some text and two buttons (accept OR dismiss)
- we accept the alert if we want to click on YES/OK
- we dismiss the alert if want want to click on NO/CANCEL

 */

package beregression;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest32 {

	static WebDriver driver; // declaring WebDriver as static
	static String uName = name(driver); // declaring uNAme as static

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// WORKING ON SIMPLE ALERT
		// we would be entering the value in the name field, clicking on alert,
		// extracting the text that the alert pop up displays and then accepting the
		// alert (clicking on OK)
		WebElement name = driver.findElement(By.cssSelector("#name"));
		name.sendKeys(uName);
		Thread.sleep(2000);

		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();

		Alert simpleAlert = driver.switchTo().alert(); // switching the webdriver context to alert, and saving it as an
														// alert

		System.out.println("Simple Alert Text : " + simpleAlert.getText()); // getting alert text
		Thread.sleep(2000); // adding wait just to see the flow
		simpleAlert.accept(); // accepting the alert
		Thread.sleep(2000); // adding wait just to see the flow

		// WORKING ON CONFIRM ALERT
		// we would be entering the value in the name field, clicking on confirm
		// extracting the text that the alert pop up displays and then dismissing the
		// alert (clicking on CANCEL)

		name.sendKeys(uName);

		WebElement confirmBtn = driver.findElement(By.cssSelector("input[id='confirmbtn']"));
		confirmBtn.click();
		Alert confirmAlert1 = driver.switchTo().alert(); // switching the webdriver context to alert, and saving it as
															// an alert
		System.out.println("Confirm Alert Text : " + confirmAlert1.getText());
		Thread.sleep(2000); // adding wait just to see the flow
		confirmAlert1.dismiss(); // dismissing the alert
		Thread.sleep(2000); // adding wait just to see the flow

		name.sendKeys(uName);
		confirmBtn.click();
		Alert confirmAlert2 = driver.switchTo().alert();
		System.out.println("Confirm Alert Text : " + confirmAlert2.getText());
		Thread.sleep(2000); // adding wait just to see the flow
		confirmAlert2.accept(); // accepting the alert
		Thread.sleep(2000); // adding wait just to see the flow

		driver.close();

	}

	public static String name(WebDriver driver) {

		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("Enter your name : ");
			String userName = userInput.next();
			System.out.println("\n");
			return userName;
		}

	}
}

/*
 * <input id="name" name="enter-name" class="inputs"
 * placeholder="Enter Your Name" type="text">
 * 
 * <input id="confirmbtn" class="btn-style" value="Confirm"
 * onclick="displayConfirm()" type="submit">
 * 
 */
