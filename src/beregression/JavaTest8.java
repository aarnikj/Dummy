//HANDLING STRINGS IN JAVA

//a String is an object that represents sequence of characters

package beregression;

public class JavaTest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ONE WAY OF CREATING A STRING OBJECT, with String Literal
		//the below objects are String literal
		String s = "Abha Joshi";
		String s1 = "Abha Joshi";
		//although we have declared two separate String objects above but Java will allocate them the same memory location
		//and point the variables to that location because the value/text is same
		
		//ANOTHER WAY OF CREATING A STRING OBJECT, using String class and new keyword	
		String s2 = new String("Hello World");
		String s3 = new String("Hello World");
		//here two separate String objects will be created because we are asking java to allocate memory space to both
		//by using new keyword
		
		
		//PERFORMING STRING ACTIONS
		String s4 = "IT IS A BEAUTIFUL DAY"; //here we created a String s4
		String[] splittedString = s4.split(" "); //split(delimiter) method is used to slit the String with
												// we have created an array from the split string values
		System.out.println("The values in the splittedString array are: ");
		//using enhanced for loop to iterate over the String s4
		for(String val : splittedString)
		{
			System.out.println(val);
		}
		
		System.out.println("\n"); //printing a new line
		
		//the newSplitString will also have whitespace added to index location 1
		String[] newSplitString = s4.split("IS");
		System.out.println("The values of newSplitString are : ");
		for(String val : newSplitString)
		{
			System.out.println(val);
		}
		
		System.out.println("\n"); //printing a new line
		newSplitString[1] = newSplitString[1].trim(); //this will trim all the left and whitespaces from a value
		System.out.println("\n"); //printing a new line
		
		System.out.println("The array values after removing the whitespaces : ");
		for(String val : newSplitString)
		{
			System.out.println(val);
		}
		
		
		System.out.println("\n"); //printing a new line
		
		
		//printing String characters
		//charAt(index) is used to get characters in a String
		String HB = "HAPPY BIRTHDAY";
		
		System.out.println("The charactes in String HB are : ");
		for(int i=0; i<HB.length(); i++)
		{
			System.out.println(HB.charAt(i));
		}
		
		System.out.println("\n"); //printing a new line
		
		//printing the string in reverse
		System.out.println("The characters of HB in reverese order are : ");
		for(int i=HB.length()-1; i>=0; i--) //here we  start from the last index position, and keep on decreasing it
											// we continue till we reach 0 index position
		{
			System.out.println(HB.charAt(i));
		}
	}

}
