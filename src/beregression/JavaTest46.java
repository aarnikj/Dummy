//WORKING WITH JAVA STREAMS
//JavaTest46

package beregression;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class JavaTest46 {

	
	
	//TEST 1 - count the number of words that starts with alphabet A in an ArrayList
	@Test
	public void regularMethod() {
		ArrayList<String> names = new ArrayList<String>();	//here we have created an ArrayList of String
		
		//now we add data to the names ArrayList
		names.add("Abha");
		names.add("Renu");
		names.add("Aarnik");
		names.add("Reyaansh");
		names.add("Vaanya");
		names.add("Atul");
		
		int count = 0; //we set the initial count to zero
		
		//now we use for loop to iterate though the ArrayList and fetch names starting with A
		for(int i=0; i<names.size(); i++) {
			String personName = names.get(i);
			if(personName.startsWith("A"))
			{
				count++; //here we increment the count if a names starting with A is found
				
			}
		}
		System.out.println("The total count of names starting with 'A' is : " + count);
	}
	
	


}
