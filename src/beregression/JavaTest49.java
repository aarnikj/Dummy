//WORKING WITH STREAMS

//USING SORT FUNCTION

package beregression;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaTest49 {
	
	@Test
	public void sort() {

	//sorting a stream, using sort() method
			//here we are using an array and converting it to a list before converting it to a stream
			//using list requires us to import java's list package
	List<String> cities = Arrays.asList("Delhi", "Jaipur", "Dehradun" , "Manipur", "Dharamshala" , "Daman");
	cities.stream().filter(s->s.startsWith("D")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
	System.out.println("\n");
	
	
	//merging of  two streams can be achieved using concat() method, and will generate a new stream
	//we have to convert both data collections to streams tp be able to use concat() method
	ArrayList<String> names = new ArrayList<String>();
	names.add("Abha");
	names.add("Renu");
	names.add("Aarnik");
	names.add("Reyaansh");
	names.add("Vaanya");
	names.add("Atul");
	
	Stream<String> newStream = Stream.concat(names.stream(), cities.stream());
	newStream.sorted().forEach(s->System.out.println(s)); //using sorted() method on the concatenated stream
}
}


