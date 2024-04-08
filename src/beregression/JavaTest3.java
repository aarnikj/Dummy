//IF_ELSE LOOP
//print whether or not a value in the array is a multiple of 2
//this has to be check for all values

package beregression;

public class JavaTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {17, 28, 82, 33, 61, 44, 62, 82, 90, 71};
		
		for(int i=0; i<arr1.length; i++) 
		{
			if (arr1[i] % 2 == 0)
			{
				System.out.println(arr1[i]);
				System.out.println("\n");
			}
			
			else
			{
				System.out.println(arr1[i] + " is not a multiple of 2");
				System.out.println("\n");	
			}
			
		}
	}
}
		

