//REVERSE TRAVERSE - CHILD TO PARENT TRAVERSE

//child to parent traverse is not possible in CSS Selector

// XPATH >> //parentTagName//childTagName/...childTagName[index]/parent::parentTagName/...../parent::parentTagName
// XPATH >> //parentTagName//childTagName/...childTagName/parent::parentTagName/...../parent::parentTagName

 //we can also traverse to child again after traversing back to parent
// XPATH >> childLocatorPath/parent::parentTagName/...../parent::parentTagName/childTagName


package beregression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//here we first go to LOGIN button and then traverse to parent and reach the blinking text on the web page header
		WebElement blinkingText = driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]/parent::div/parent::header/a[@class='blinkingText']"));
        System.out.println("The blinking text is : " + blinkingText.getText());
        driver.close();
        
       
	}

}


