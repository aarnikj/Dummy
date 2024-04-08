//ACTIONS ON WEB ELEMENT ON A WEB PAGE
//the below capabilities are present from Selenium4

//1. here we take screenshot of a particular web element on a web page

//2. we also capture the height & width of a specific web element

package beregression;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest60 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));
	    nameEditBox.sendKeys("Life is Beautiful");
		
		//1. TAKING SCREENSHOT OF A SPECIFIC WEB ELEMENT
	    //to get a screenshot in a file, we use FILE class and declare the output type as file
	    //we then use FileUtils package to enable all of its functions, 
	    //we have add FileUtils jar (from Apache as it is the first owner of the jar) to Selenium project ourself, it does not show by default
	    //adding jar to Selenium requires us to download the jar and then import it to java project (Project(right-click) > Properties > Java Build Path > Add external jars)
	    //we just copyFile(srcFile, destFile) to copy the screenshot we got and save it to a file
	    File file = nameEditBox.getScreenshotAs(OutputType.FILE); //taking the screenshot
	    
	    FileUtils.copyFile(file, new File("nameField.png")); //we now specify the source and destination file names
	    												//this step requires us to add IOException
	    
	    /*
	    -- after we are done taking the screenshot, we have to refresh our project (Project(right-click) > Refresh)
	    -- to check the file, File(right-click) > Location browse button > open the file)
	    
	    -- Taking screenshots of a web element is useful where in we are not able to sit and see through the test execution (like in remote VMs)
	    but we want to check how a particular web element looked after the test execution
	    
	    */
	    
	    
	    //2. CAPTURING HEIGHT & WIDTH OF A WEB ELEMENT
	    //here we are capturing the height and width of nameEditBox, this can be achieved using getRect().getDimension() methods
	    
	    int heightNEB = nameEditBox.getRect().getDimension().height; //capturing height
	    System.out.println("Height of name edit box : " + heightNEB); //printing height
	    
	    System.out.println("Width of name edit box : " + nameEditBox.getRect().getDimension().width); //capturing + printing width
	    
	    driver.close();
		

	}

}
