//handling int arrays in java

package beregression;

public class JavaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//one way of describing an array
		//THIS ARRAY HAS A DISADVANTAGE AS WE HAVE TO ASSIGN THE MEMORY TO THE ARRAY IN THE BEGINING 
		//BY DEFINING THE ARRAY SIZE
		int[] arr1 = new int[6];
		arr1[0] = 25;
		arr1[1] = 78;
		arr1[2] = 86;
		arr1[3] = 35;
		arr1[4] = 99;
		arr1[5] = 24;
		
		//another way to describe an array
		//THIS ARRAY HAS A DISADVANTAGE AS WE HAVE TO ASSIGN THE MEMORY AND VALUES TO THE ARRAY IN THE BEGINING 
		//BY DEFINING THE WHOLE ARRAY WITH VALUES
		int[] arr2 = {78, 76, 32, 84, 32, 23};
		
		
		
		//using FOR loop to print array
		//here we take a iterator i and initialize its value
		//value of arr1[i] is printed
		//the i is checked against the length of arr1 i.e 5
		//i is then increased by 1
		System.out.println("Elements of arr1 are :" );
		for (int i=0; i<arr1.length; i++)
		{
		System.out.println(arr1[i]);
		}
		
		System.out.println("\n"); //this prints a new line
		
		System.out.println("Elements of arr2 are :" );
		for(int j=0; j<arr2.length; j++) 
		{
			System.out.println(arr2[j]);
		}
		
		//printing array values at an index location
		System.out.println("\n" + "Third element of first array is : " + arr1[2]);
		System.out.println("\n" + "Fifth element od second array is : " + arr2[4]);
	}


		
	}

