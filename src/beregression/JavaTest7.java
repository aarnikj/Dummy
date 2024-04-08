//converting traditional array to ArrayList

package beregression;

import java.util.Arrays;
import java.util.List;

public class JavaTest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrayTrad = {29, 17, 38, 91, 71, 36, 82}; //defining traditional array of integers
		
		//converting the array to ArrayList
		List<int[]> arrayNew = Arrays.asList(arrayTrad);
		System.out.println("Is age 62 present in  the array? : " + arrayNew.contains(62));
		
		System.out.println("\n"); //printing a new line
		
		String[] arrString = {"banana", "mango", "orange", "peach"}; //defining traditional array of string values
		List<String> arrStringNew = Arrays.asList(arrString);
		System.out.println("Does the array contains MANGO? : " +	arrStringNew.contains("mango"));

	}

}
