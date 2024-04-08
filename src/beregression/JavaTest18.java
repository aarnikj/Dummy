//SIBLING LOCATOR STRATEGIES - SIBLING TO SIBLING TRAVERSE

// we would be using rahulsettyacademy/automationpractice web page for this

//here we will first go to a child using parent to child path and then from one sibling to another
//this is useful in scenarios where one of the siblings is dynamic and we want to perform actions on it based on another sibling

/*
 while writing a locator path to a web element, id we start the path wit single slash / it refers to the absolute path, // represents relative path
 it is recommended to use relative path because it is shorter and the path remains intact in case the developer makes any updates to the web page
 using the absolute will break it in case there are any add-ons/deletions made by the developer as it will introduce new tags or delete some of the existing tags
 */
package beregression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//we are assuming here that the LOGIN button next to PRACTICE button is dynamic, 
		//so to click on it after the loads, we traverse to it from its sibling
		//XPATH >> //parentTagName/childTagName/.....childTagName[index]/following-sibling::siblingTagName[index]
		//XPATH >> //parentTagName/childTagName/.....childTagName/following-sibling::siblingTagName
		WebElement loginBtn = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")); 
		//here we first traverse from parent to child and then from sibling to sibling
		
		System.out.println("Login button text : " + loginBtn.getText()); 
		//getting text of the login button since the buttons are dummy buttons
	
		driver.close();

	}

}
