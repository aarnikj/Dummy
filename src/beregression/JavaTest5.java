//HANDLING DYNAMIC ARRAYS IN JAVA, WE USE ARRAYLIST CLASS FOR THIS

package beregression;

import java.util.ArrayList;

public class JavaTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//here we are creating an object of ArrayList class, called arrString
		//new keyword is used to allocate memory to the class instance
		//<String> tells that the array is of String type
		//we don't have to declare the array values beforehand, those can be added dynamically
		
		ArrayList<String> arrString = new ArrayList<String>();
		arrString.add("mango");
		arrString.add("banana");
		arrString.add("pear");
		arrString.add("orange");
		
		
		//get(int index) method is used to extract value at an index location in ArrayList
		System.out.println("The fourth element is : " + arrString.get(3));
		System.out.println("\n"); //adding a new line
		
		
		//size() method is used to get the size of ArrayList
		//using for loop to iterate over the ArrayList
		System.out.println("The elements in the array are : ");
		for(int i=0; i<arrString.size(); i++)
		{
			System.out.println(arrString.get(i));
		}	
		
		System.out.println("\n"); //adding a new line
		
		arrString.add("papaya"); //adding a new value to the ArrayList
		
		System.out.println("The new array elements (after adding PAPAYA) are : ");
		for (int i=0; i<arrString.size(); i++)
		{
			System.out.println(arrString.get(i));
		}
		
		System.out.println("\n"); //printing a new line
		
		
		//remove(int index) is used to delete a element from an ArrayList at the specified index location
		arrString.remove(2);
		
		//using enhanced for loop in ArrayList
		System.out.println("The new array elements (after removing the element at index position 2) are :");
		for(String fruit: arrString)
		{
			System.out.println(fruit);
		}
		
		System.out.println("\n"); //printing a new line
		
		//TO CHECK IF A VALUE IS PRESENT IN THE ARRAYLIST
		//this can be checked using contains(value) method, it returns a boolean value
		//contains method is not available in traditional arrays, we can use if loop to check this
		boolean value1 = arrString.contains("strawberry");
		System.out.println("Does the given array contains word STRAWBERRY? : " + value1);
		
		System.out.println("\n"); //printing a new line
		
		System.out.println("Does the given array contains word BANANA? : " + arrString.contains("banana"));
	}

}
