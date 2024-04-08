//WORKING WITH STREAMS

//USING MATCH FUNCTION

package beregression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaTest50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//match() method is used to check if a value is against elements in a data collection
		//anyMatch() checks if a provided value is present in any of the elements
		//allMatch() checks if a provided value is present in all of the elements
		//noneMatch() checks if a provided value is present in none of the elements
		//all the above method takes a lambda expressions and returns a boolean value
		
		List<String> cities = Arrays.asList("Delhi", "Jaipur", "Dehradun" , "Manipur", "Dharamshala" , "Daman");
		Stream<String> citiesStream = cities.stream();
		boolean flag = citiesStream.anyMatch(s->s.equalsIgnoreCase("Delhi"));
		System.out.println(flag);
		Assert.assertTrue(flag, "the given word is not found");
		
	}

}
