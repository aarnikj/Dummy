//VALIDATING ALL THE LINKS IN A WEB PAGE

//HERE WE USE SOFT ASSERTION TO KNOW THE TEST RESULT
//HARD ASSERTION WILL FAIL THE TEST AS SOON AS IT ENQUIRES A SINGLE FAILURE
//HOWEVER, SOFT ASSERTION WILL COMPLETE ALL THE STEPS IN THE TEST AND WILL REPORT THE TEST SUCCESS/FAILURE AT THE END

package beregression;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class JavaTest45 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> pageLinks = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		//using SoftAssert class from testng 
		SoftAssert sa = new SoftAssert();
		
		for(WebElement link : pageLinks)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection urlConn = (HttpURLConnection) new URL(url).openConnection();
			urlConn.setRequestMethod("HEAD");
			urlConn.connect();
			int urlConnResponseCode= urlConn.getResponseCode();
			
			System.out.println(link.getText() + " response code : " + urlConnResponseCode);
			sa.assertFalse(urlConnResponseCode>400, "The " + link.getText() + " is a broken link, with response code " + urlConnResponseCode);
		}
		
		sa.assertAll(); //assertAll() method reports the results of soft assertion
		
		driver.quit();

	}

}
