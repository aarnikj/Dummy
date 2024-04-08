//VALIDATING ALL THE LINKS IN A WEB PAGE

//HERE WE USE IF-ELSE LOOP TO KNOW THE TEST RESULT

package beregression;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest44 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		//WebDriver driver;
		//driver = new ChromeDriver();
		
		WebDriver driver = (WebDriver) new ChromeDriver(); //another way of creating a driver object from WebDriver class
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> pageLinks = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for( WebElement link : pageLinks)
		{
			String url = link.getAttribute("href");
			HttpURLConnection urlConn = (HttpURLConnection) new URL(url).openConnection();
			urlConn.setRequestMethod("HEAD");
			urlConn.connect();
			int urlConnResponseCode= urlConn.getResponseCode();
			
			if(urlConnResponseCode > 400)
			{
				System.out.println(link.getText() + " is a broken link, having response code : " + urlConnResponseCode  );
			}
			else
			{
				System.out.println(link.getText() + " is a valid link, having response code : " + urlConnResponseCode  );
			}
		}
		
		driver.close();
	}

}
