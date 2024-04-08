//WORKING WITH STREAMS

//using distinct method 

//here we take a list, an print unique vales from it and then sort the result

package beregression;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaTest52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> ages = Arrays.asList(30, 67, 97, 35, 30, 89, 67, 34, 97, 30);
		System.out.println("Distinct values are:");
		ages.stream().distinct().forEach(s->System.out.println(s)); //distinct method prints out unique values from a stream
		System.out.println("\n");
		System.out.println("Sorted values:");
		ages.stream().distinct().sorted().forEach(s->System.out.println(s));
		System.out.println("\n");
		
		//we can also convert the list to set to print distinct values, but in this case output data type would be different from the input data type
		Set<Integer> agesSet = ages.stream().collect(Collectors.toSet());
		System.out.println(agesSet);
		System.out.println("\n");
		
		System.out.println("age groups in sorted order:");
		agesSet.stream().sorted().forEach(s->System.out.println(s));
		
		/* this can also be used
		List<Integer> agesSort = agesSet.stream().sorted().collect(Collectors.toList());
		System.out.println(agesSort);
		*/
		
	}

}
