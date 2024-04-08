//HANDLING STATIC DROP DOWN OF A DIFFERRENT KIND

//here we select number of passengers, here we use FOR LOOP

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest23 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // check the best implicit wait duration

		WebElement passengersDD = driver.findElement(By.id("divpaxinfo"));
		passengersDD.click();

		WebElement addAdult = driver.findElement(By.id("hrefIncAdt"));
		WebElement addChild = driver.findElement(By.id("hrefIncChd"));
		WebElement addInfant = driver.findElement(By.id("hrefIncInf"));

		Thread.sleep(1000);
		// let's say we want to click 4 adults, 2 infants and 3 children : the web site
		// has a limit to select only 9 passengers at a time

		for (int a = 1; a <= 3; a++) // clicking a only two times because the 1 adult is selected by default
		{
			addAdult.click();
		}

		for (int c = 1; c <= 3; c++) {
			addChild.click();
		}

		for (int i = 1; i <= 2; i++) {
			addInfant.click(); // clicking on done button
		}

		Thread.sleep(1000);

		WebElement passengerNum = driver.findElement(By.cssSelector(".paxinfo"));
		System.out.println("Passengers Num is  : " + passengerNum.getText());

		driver.close();

	}

}
