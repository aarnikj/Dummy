//WORKING WITH STREAMS

//USING COLLECT METHOD

//collect method is used to convert a stream to a data collection (LIST or SET)

package beregression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class JavaTest51 {
	
	@Test
	public void streamCollect() {
		
		//here we take a list, convert it into a stream to do the required data manipulations and convert the output stream to a new list
		//we have to import the package java.util.stream.Collectors
		List<String> fruitsOld = Arrays.asList("Mango", "Banana", "Papaya", "Pineapple", "Blueberry", "Plum");
		List<String> fruitsP = fruitsOld.stream().filter(s->s.startsWith("P")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("Fruit names starting with P in the given list are : " + fruitsP);
		System.out.println("First fruit in the new list is : " + fruitsP.get(0)); //printing only the first fruit from the new list
		
	}

}
