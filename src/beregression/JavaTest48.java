//WORKING WITH STREAMS
//WORKING WITH MAP

//map method is used to manipulate a stream

package beregression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaTest48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abha");
		names.add("Renu");
		names.add("Aarnik");
		names.add("Reyaansh");
		names.add("Vaanya");
		names.add("Atul");
		
		//here we print the names that ends with A in upper case format
		//map() method also uses lambda expressions
		Stream.of("Abha", "Atul", "Renu", "Reyansh", "Vaanya", "Abhilasha", "Ananya").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println("\n");
		
		//print all the names in upper case
		names.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s));;
		System.out.println("\n");
		
		//sorting a stream, using sort() method
		//here we are using an array and converting it to a list before converting it to a stream
		//using list requires us to import java's list package
		List<String> cities = Arrays.asList("Delhi", "Jaipur", "Dehradun" , "Manipur", "Dharamshala" , "Daman");
		cities.stream().filter(s->s.startsWith("D")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		System.out.println("\n");
	}

}
