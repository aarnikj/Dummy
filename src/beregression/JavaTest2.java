//handling String arrays in java

package beregression;

public class JavaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = {"apple" , "banana", "pear", "grapes", "mango"};
		
		System.out.println("The second fruit in the array is : "  + fruits[1]);
		
		System.out.println("\n" + "The fruit names are :");
		for (int i=0; i<fruits.length; i++) 
		{
			System.out.println(fruits[i]);
		}
		
		System.out.println("\n");
		
		for (String f: fruits)
		{
			System.out.println(f);		
		}
	}

}
