//ACCESSING METHODS USING JAVA CLASS OBJECTS

package beregression;

import java.util.Scanner;

public class JavaTest9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//to access the method that we created below, we first need to create & initialize an object of the class it belongs to
		//and then call the method on it
		JavaTest9 helloUser = new JavaTest9();
		helloUser.helloWorld();
	
		
		JavaTest9 bFriend = new JavaTest9();
		String bf = bFriend.friend();
		
		System.out.println(bf + " is your best friend");
	}
		
		//System.out.printf(bf);
	
	//if we have a code that we would like to repeat, then we can create a method for it and call it using java class objects
	public void helloWorld() {
			
		try (Scanner userNameInput = new Scanner(System.in)) {
			System.out.println("Enter your name :");
			String userName = userNameInput.nextLine();
			System.out.println("Hello " + userName + ", Nice to meet you.");
			
			
		}	
		
	}
	
	
	public String friend() {
			String bestFriend = "Suman Tiwari";
			return bestFriend;
		
		
		
	}
	

}
