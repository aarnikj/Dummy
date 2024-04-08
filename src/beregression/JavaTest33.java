//ONLINE CART SHOPPING 

//here we go to a ONLINE CART web page
//pass on an array of shopping items
//add the array items to the cart >> verify the number of items in the cart
//click on the cart icon >> click on proceed checkout
//apply the promocode >> click on apply button >> verify that the promocode is applied successfully

package beregression;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class JavaTest33 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		String[] shoppingItems = {"Cucumber", "Apple", "Almonds", "Potato", "Tomato"}; //defining the items array
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		addItems(driver, shoppingItems);
		

		WebElement cartItems = driver.findElement(By.xpath("//div[@class='cart-info']/table/tbody/tr/td[3]/strong")); 
		System.out.println("Cart Items : " + cartItems.getText()); //printing the number of items in the cart
		System.out.println("\n");
		
		WebElement cartIcon = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		cartIcon.click();
		
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='cart-preview active']/div/div/ul/li/div/p[@class='product-name']"));
		
		System.out.println("Items added in the cart are");
		for(int i=0; i<productList.size(); i++)		
		{
			String itemName = productList.get(i).getText();
			System.out.println(itemName);
		}
		
		System.out.println("\n");
		
		WebElement proceedCheckout = driver.findElement(By.xpath("//div[@class='action-block']/button"));
		proceedCheckout.click();
		WebElement promoCode = driver.findElement(By.cssSelector("input.promoCode"));
		promoCode.sendKeys("rahulshettyacademy");
		WebElement applyPromoBtn = driver.findElement(By.cssSelector("button.promoBtn"));
		applyPromoBtn.click();
		
		//adding explicit wait for promoText to appear since it's taking some time to load after we click on apply button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div/span[text()='Code applied ..!']"))));
		
		
		WebElement promoText = driver.findElement(By.xpath("//div[@class='promoWrapper']/span"));
		//WebElement prompText = driver.findElement(By.xpath("//div/span[text()='Code applied ..!']")); //another way of writing xpath for promoText
		System.out.println("Promo Code Result : " + promoText.getText());
		Assert.assertEquals(promoText.getText(), "Code applied ..!"); //putting assertion
	
		
		
		//div/span[text()='Code applied ..!']
		
		driver.close();
		
	}
	
		
		public static void addItems(WebDriver driver, String[] shoppingItems) {
			int j = 0; //initializing a variable to keep check on the if loop of clicking add to cart button
			
			//extracting all the product names, this returns a list of web elements
			List<WebElement>  products = driver.findElements(By.cssSelector("h4.product-name")); //css locator can be written as attribute.className
			
			for(int i=0; i<products.size(); i++)
			{
				//the array does not have Cucumber - 1kg written type for the shopping items so the match would not be found
				//in this case, we will have to extract the values we are getting from the list of web elements to match the shopping items
				
				String[] itemName = products.get(i).getText().split("-"); //split() method returns an array so that's why storing it as an array
				String actualItemName = itemName[0].trim(); //extracting the value at the first index and applying trim() method to get rid of left and right white spaces
				
				
				//we now have to convert our shoppingItems[] array to ArrayList so that we can easily perform search operations on it
				//it is recommended to first store the items as an array because it uses less memory and convert it to an ArrayList as and when the need arises
				//ArrayList are useful to validate complex test scenarios
				
				List<String> shoppingItemsAL = Arrays.asList(shoppingItems);
				
				
				
				if(shoppingItemsAL.contains(actualItemName)) //this checks if  the shoppingItemsAL contains the itemName that we are getting in  the for loop
				{
					j++;
					
					List <WebElement> addToCart = driver.findElements(By.xpath("//div[@class='product-action']/button")); //extracting all the add to cart buttons, this returns a list of web elements
					addToCart.get(i).click(); //clicking on add to cart button for the item matched
					
					//we have to add a loop counter to only allow entry to this loop till the count is 5
					//this block does not contains break statement in a traditional way means stop the loop once the item is matched and add to cart button is clicked
					//because it will make the java interpreter exit the code once the add to cart button is clicked for the first matched item of the ArrayList
					
					if(j==shoppingItems.length)
					{
						break; //this takes the control out of if loop after j becomes 5
					}
				}
			}
	
		}
}



		
		
		
		//we can add a breakpoint in the code (right click >> Toggle Breakpoint) and run the code in debug mode if we want to see how the code is working and the steps are being executed
		//breakpoint stops the code execution and resumes only with our permission/actions
		//we would have to run our code in debug mode to see this (Run Menu >> Debug As >> Java Application)
		//eclipse will prompt us to open debug perspective for this
		//in the debug perspective window, the current step will be highlighted
		//variables, breakpoints and expressions are also visible/listed on a side panel
		//the code execution will also stop at breakpoints that we defined and highlight it
		//to execute the next step, click Step Over
		//to go inside a code block, click Step Into
		//to run the code till next breakpoint, or till end in case of no further breakpoint, click Resume



/*
  
  <button class="" type="button">ADD TO CART</button>
  
  //*[@id="root"]/div/header/div/div[3]/div[1]/table/tbody/tr[1]/td[3]/strong
  
 <a class="cart-icon" href="#"><img class=" " src="https://rahulshettyacademy.com/seleniumPractise/images/bag.png" alt="Cart"></a> 
 
 <input type="text" class="promoCode" placeholder="Enter promo code">
 input.promoCode
 
 */
