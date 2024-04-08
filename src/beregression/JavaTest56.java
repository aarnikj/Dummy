//THIS CODE IS NOT WORKING

package beregression;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaTest56 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//open the web page
		
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//grab the vegetable list
		WebElement vegHeaderArrow = driver.findElement(By.xpath("//tr/th[1]"));
		vegHeaderArrow.click();
		
		List<String> veggies;
		List <String> vegetables = new ArrayList<String>();
		
		do {
		List<WebElement> originalVegList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		veggies = originalVegList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		vegetables = Stream.concat(vegetables.stream(), veggies.stream()).collect(Collectors.toList());
		
		Thread.sleep(2000);
		
		WebElement nextBtn = driver.findElement(By.xpath("//a[@role='button'][@aria-label='Last']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(nextBtn));
		
		
		nextBtn.click();
		
		} while (veggies.size() < 6);
		
		driver.close();
		
		
		//grab the price list
		
		
		//map items
	}

}
