package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RoughWork {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement ffCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		ffCheckbox.click();
		Thread.sleep(1000);
		Assert.assertTrue(ffCheckbox.isSelected());
		ffCheckbox.click();
		Assert.assertFalse(ffCheckbox.isSelected());
		
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println("Number of checkboxes : " + checkboxes.size());
		driver.close();

	}

}
