//AN EXAMPLE TO SHOW HOW TO HANDLE FRAMES IN A WEB PAGE
// WE WILL ALSO WORK ON DRAG AND DROP MOUSE ACTION


//a frame starts with <iframe> tag
//web driver context to iframes can be switched using index number of the frame, passing iframe as web element, frame name


//here we go to a web page, go inside an iframe to perform drag and drop action
package beregression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaTest37 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		//this step get the total iFrames present in a web page, it is optional, using it here just to know, this can be checked under developer tools too
		List<WebElement> totalFrames= driver.findElements(By.tagName("iframe"));
		System.out.println("Total iFrames : " + totalFrames.size());
		System.out.println("\n");
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']")); //locating the iframe
		driver.switchTo().frame(iframe); //switching web driver's context to iframe
		Thread.sleep(1000);
		
		Actions a = new Actions(driver);
		
		//location source and target for drag and drop
		WebElement dragIcon = driver.findElement(By.id("draggable"));
		WebElement dropIcon = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(dragIcon, dropIcon).build().perform();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent(); //switching back driver context to the default window
		System.out.println("Page Title : " + driver.getTitle());
		
		driver.close();
		
		
	}

}
