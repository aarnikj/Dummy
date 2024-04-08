
//HANDLING DYNAMIC ARRAYS OF INTEGERS WITH ENCHANCED FOR LOOP

package beregression;

import java.util.ArrayList;


public class JavaTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating a new object of integers from ArrayList class
		ArrayList<Integer> ages = new ArrayList<Integer>();
		
		ages.add(20); //adding integer 20 to the ArrayList, using method add(int)
		ages.add(1, 30); //adding integer 30 at index position 1, using method add(index, int)
		ages.add(16);
		ages.add(82);
		ages.add(4, 27);
		
		//using enhanced for loop to iterate through the array
		System.out.println("The ages array contains the following values");
		for(int value: ages)
		{
			System.out.println(value);
		}
		
		System.out.println("\n"); //printing a new line
		
		ages.remove(2); //removing value at index position 2, using method remove(index)
		System.out.println("The new ages array is (values after removing  the element at index position 2)");
		for(int value: ages)
		{
			System.out.println(value);
		}
		
		
		
	}

}
