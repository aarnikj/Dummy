//identify broken links in a web page


//broken links have broken URLs - links that cannot find a URL
//here Selenium works along with Java methods to identify the status code for such links, any link with a status code above 400 is a broken link

/*
 STEP 1 : land on the web page in which you want to scan the links using Selenium web driver
 STEP 2 : fetch all URLs tied up to the links on the web page using Selenium web driver
 STEP 3: use java methods to call the retrieved URLs and get the status code
 */
package beregression;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaTest43 {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//working on a valid link 
		//HERE WE USE SELENIUM CONCEPTS
		//here we first try to check a valid link
		//in the below step: we first find the link web element, then get its href attribute's value and store it in a string as getAttribute() method returns a string
				
		String soapUiUrl= driver.findElement(By.linkText("SoapUI")).getAttribute("href"); //this will give us the url to soapui page
        System.out.println("SOAPUI URL : " + soapUiUrl );
		
		//HERE WE USE JAVA CONCEPTS
		//we can check if the link is working properly by clicking on the web element. However, this will become tedious in case of validating hundreds or thousands of links in a page
		//to overcome this and validate a link, we use HttpURLConnection class
		//in the below step: we use HttpURLConnection class to create an object of the class, then we cast the object with the HtttpURLConnection class, and then use openConnection() method on the object
		//we have to import java.net.HttpURLConnection and java.net.URL packages
		//Casting allows us to convert an object of one type into another, and it’s used in a variety of different scenarios. 
		//openConnection() method returns a URLConnection instance that represents a connection to the remote object referred to by the URL 
		//By default the HTTP request method is GET. You can call the setRequestMethod(String method) to set the request method which is one of GET, POST, HEAD, PUT, DELETE, TRACE, and OPTIONS.
		//When processing a HEAD request, the server returns a response without the body content. Only the header fields are returned. Hence the method name “HEAD”.
		HttpURLConnection soapUiConn = (HttpURLConnection) new URL(soapUiUrl).openConnection();
		soapUiConn.setRequestMethod("HEAD");
		soapUiConn.connect(); //we are now connecting to the URL
		int soapUiConnResponseCode = soapUiConn.getResponseCode(); //we now try to fetch the response code that we got from HEAD request
		System.out.println("The Response Code for SOAP UI link is : " + soapUiConnResponseCode);
		System.out.println("\n");
		

		//working on a broken link
		String brokenLinkUrl = driver.findElement(By.linkText("Broken Link")).getAttribute("href"); //this will give us the url of the broken link page
		System.out.println("BROKEN LINK URL : " + brokenLinkUrl );
		
		HttpURLConnection brokenLinkUrlConn = (HttpURLConnection) new URL(brokenLinkUrl).openConnection() ;
		brokenLinkUrlConn.setRequestMethod("HEAD");
		brokenLinkUrlConn.connect();
		int brokenLinkConnResponseCode = brokenLinkUrlConn.getResponseCode();
		System.out.println("The Response Code for BROKEN LINK link is : " + brokenLinkConnResponseCode );
		
		driver.close();
		
	}

}


//<a href="http://www.restapitutorial.com/">REST API</a>