//taking browser screenshot using Selenium

package beregression;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest42 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		
		//here we cast the web driver with TakesScreenshot() method which makes it aware about taking the screenshot. Package imported for this is org.openqa.selenium.TakesScreenshot
		//we then use the getScreenshotAs() method to specify the output type
		//Output type specifies the screenshot format. Package imported for this is org.openqa.selenium.OutputType
		//we also have to import java.io.File package
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		//we then use the fileUtils package to copy the screenshot to the desired location with the desired name
		FileUtils.copyFile(src, new File("//Users/Pradeep.Tomar/Desktop/AARNIK/screenshot.jpeg"));
		
		System.out.println("Page Title : " + driver.getTitle());
		
		driver.close();
		
	}

}
