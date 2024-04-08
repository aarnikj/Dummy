//ACCESSING METHODS USING STATIC KEYWORD


//used mostly when the method is present in its own class
//when we add static keyword to a method then that method moves to the class level
//and we no more need to create objects for it, the method can be accessed directly

package beregression;

import java.util.Scanner;

public class JavaTest10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
				JavaTest10 helloUser = new JavaTest10();
				helloUser.helloWorld();
		
				//accessing friend() method without creating any object
				String bf = friend();
				
				System.out.println(bf + " is your best friend");
			}
			
			
			public void helloWorld() {
					
				try (Scanner userNameInput = new Scanner(System.in)) {
					System.out.println("Enter your name :");
					String userName = userNameInput.nextLine();
					System.out.println("Hello " + userName + ", Nice to meet you.");
					
					
				}	
				
			}
		
			
			public static String friend() {
				
				String bestFriend = "Suman Tiwari";
				return bestFriend;
				}
	}

