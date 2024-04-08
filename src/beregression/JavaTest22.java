//HANDLING STATIC DROP DOWN OF A DIFFERRENT KIND

//here we select number of passengers, here we use WHILE LOOP

package beregression;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaTest22 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //check the best implicit wait duration
		
		/*
		 The default wait time for implicit wait in Selenium WebDriver is 0 seconds. This means that if an element is not immediately available, 
		 the WebDriver will continue to try and find the element for the entire duration of the specified implicit wait time. 
		 If the element is found before the implicit wait time expires, the execution will continue immediately.
		 */
		
		WebElement passengersDD = driver.findElement(By.id("divpaxinfo"));
		passengersDD.click();
		
		WebElement addAdult = driver.findElement(By.id("hrefIncAdt"));
		WebElement addChild = driver.findElement(By.id("hrefIncChd"));
		WebElement addInfant = driver.findElement(By.id("hrefIncInf"));
		WebElement doneButton = driver.findElement(By.id("btnclosepaxoption"));
	
		/*
		 suppose we are working on a code that requires us to perform actions on a web elements for a specific number of times, we can write duplicate lines of code as it will increase the code complexity
		 Instead, we use WHILE LOOP to achieve this
		 
		 while(true)
		    {
		      do;
		    }
		 
		 here the while loop will keep on executing the enclosed code until the statement provided is true, it will stop only when the condition becomes false
		 
		 for while loop, we have to first do initialization, then put a comparison condition and then execute a set of code
		*/
		
		//let's say we want to click 4 adults, 2 infants and 3 children : the web site has a limit to select only 9 passengers at a time
		
		int a = 1; //clicking addAdult only three times because the 1 adult is selected by default
		while(a<=3)
		{
			addAdult.click();
			a++;
		}
		
		int c = 1;
		while(c<=2)
		{
			addChild.click();
			c++;
		}
		
		int i = 1;
		while(i<=3)
		{
			addInfant.click();
			i++;
		}
		
		doneButton.click(); //clicking on done button
		
		Thread.sleep(1000);
		
		
		
		WebElement passengerNum = driver.findElement(By.cssSelector(".paxinfo"));
		System.out.println("Passengers Num is  : " + passengerNum.getText());
		
		driver.close();
	}

}



/*

<div id="divpaxinfo" class="paxinfo">1 Adult</div>

<span class="pax-add pax-enabled" id="hrefIncAdt">+</span>

<div class="ad-row-right">
 
 <span class="pax-add pax-disabled" id="hrefDecAdt" disabled="disabled">-</span>
 
 <span class="pax-add pax-enabled" id="hrefIncInf" disabled="disabled">+</span>
 
 <span class="pax-add pax-enabled" id="hrefIncChd">+</span>

<input class="buttonN" id="btnclosepaxoption" value="Done" type="button">

*/