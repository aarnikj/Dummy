//USING ACTIONS CLASS

//this class is used to perform mouse and keyboard interactions within a web page
//it is also used to facilitate mouse hover on a web page
//context click (right-click), double click, drag & drop actions on a web element can also be performed 

//in this example we go to amazon.com web page, mouse over to sign in drop down and check if sign on drop down is displayed

//we then go to search bar, type something in it in capital letters and validate the typed words

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaTest35 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement signInDD = driver.findElement(By.id("nav-link-accountList"));
		
		//now to mouse over to the signInDD we would be using ACTIONS class
		Actions a = new Actions(driver); //we have to pass driver as an argument to the Actions class so that it can facilitate the action class methods
		a.moveToElement(signInDD).build().perform(); //moveToElemenet() moves the mouse cursor to the specified web element
													//build() method builds the action, perform() method performs it
		
		Thread.sleep(1000); //added just to see the process flow
		
		
		//typing a few words in search bar
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));		
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("hair color").build().perform(); //this is a composite action (combining multiple actions)
		Thread.sleep(1000);																							// after we mouse hover to the search bar, we have to click on it to start typing
																										//keyDown() method holds the specified key, here shift key to capitalize the input letters
		       																							//input letters case does not matter here as we have already held the shift key	
		
		
		searchBar.clear();
		Thread.sleep(1000); //added just to see the process flow
		
		
		a.moveToElement(searchBar).click().sendKeys("babywipes").doubleClick().build().perform(); //doubleClick() selects the text
		Thread.sleep(2000); //added just to see the process flow
		
		WebElement amzHome = driver.findElement(By.linkText("Amazon Home"));
		a.moveToElement(amzHome).contextClick().build().perform(); //contextClick() is used to right click
		Thread.sleep(1000); //added just to see the process flow
		
		driver.close();

	}

}
