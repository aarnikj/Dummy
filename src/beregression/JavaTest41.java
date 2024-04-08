//HANDLING INSECURE BROWSER CERTIFICATES

package beregression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaTest41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//we use ChromeOptions class to set browser behavior for handling insecure web site certificates.
		//we need to import the package org.openqa.selenium.chrome.ChromeOptions for this
		//we use FirefFoxOptions class for Mozilla FireFox web browser
		///we use SafariOptions class for Safari web browser
		///we use EdgeOptions class for Microsoft Edge web browser
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); //setAcceptInsecureCerts() method can be used to accept insecure browser certificates
		
		WebDriver driver;
		driver = new ChromeDriver(options); //we have to now pass options as an argument ChromeDriver class so that it know which browser behavior to handle
		driver.get("https://expired.badssl.com/");
		System.out.println("Page Title : " + driver.getTitle());
		
		driver.close();

	}

}
