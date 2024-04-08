//WORKING WITH JAVA STREAMS
//JavaTest47

	//TEST 2 - now we optimize the last code using STREAMS
	//here we use filter() method on streams

package beregression;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaTest47 {
	
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abha");
		names.add("Renu");
		names.add("Aarnik");
		names.add("Reyaansh");
		names.add("Vaanya");
		names.add("Atul");
		
		//STREAMS DO NOT MODIFY THE DATA SOURCE OR CHANGE THE DATA TYPE, THEY JUST PERFORM OPERATIONS ON THEM
		//we first have to assign the names ArrayList to streams so as to make it stream compatible and to be able to conduct intermediate and terminal operations of steams on it
				//here stream is nothing but a collection of strings.
				//in the stream API, there is a method called filter() which filters the input stream based on the condition 
				//we specify the condition using lambda expression.
				//lambda expression is divided into two parts: Left side specified the parameter(s) and the right side specifies the action/condition to be performed on the parameter(s)
				//Let’s say we take a parameter s here. So this parameter will be scanning this whole list (collection) every time. The list items are scanned in parallel as opposed to in sequence while using if or for statements.
				//we use s.startsWith() condition on s parameter, same thing.
				//The filter() method takes as an argument a lambda expression where left side is the variable first you need to declare, and right side takes in the action/condition to be performed on the variable and it'll filter all this.
				//filter() method returns true for a match and false in case of a no match. It is as an intermediate operation.
				//working of stream can be explained in three stages. First of all, create a stream. Second, perform intermediate operation(s) on the initial stream (like filter here). 
				//Filter method returns a new stream comprising of the names starting with “A”. Third, perform terminal operation on the final stream (count here)
				//Now, there are some intermediate operations which will only execute if you give a terminal operation. Filter is one of the intermediate operation here. 
				//The life of an intermediate operation exists only if you have terminal operation.
				//terminal operations will execute only if the intermediate operation returns true or returns a value
				//On the final stream, count method is applied to count the number of names in the stream returned by the filter  grab this into one variable
				//Data type of count is long here
		
		long count = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println("The total count of names starting with 'A' is : " + count);
		System.out.println("\n");
		
		
		//we can also define streams in the below manner (using stream package), it's not necessary to have a data source converted to streams every time
		//for this we need to import the stream package java.util.stream
		long count1 = Stream.of("Abha", "Atul", "Renu", "Reyansh", "Vaanya").filter(s->s.endsWith("a")).count();
		System.out.println("The total count of names ending with 'A' is : " + count1);
		System.out.println("\n");
		
		
		//using multiple lambda expressions for filter method
		long count2 = Stream.of("Abha", "Atul", "Renu", "Reyansh", "Vaanya", "Abhilasha", "Ananya").filter(s->s.startsWith("A") && s.endsWith("a")).count();
		System.out.println("The total count of names starting and ending with 'A' is : " + count2);
		System.out.println("\n");
		
		
		//here we print all the names whose length is greater than 4
		//we use forEach loop to iterate through the stream we got using filter() method
		//forEach loop is a terminal operation and uses lambda expressions
	    //we use the already created names array list for this
		System.out.println("Names with length greater than 4 are:");
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		System.out.println("\n");
		
		//to print only the limited results we get from filter() method, we can use limit function, and then use forEach loop on the returned stream
		System.out.println("First two names with length greater than 4 are:");
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
	}

}
