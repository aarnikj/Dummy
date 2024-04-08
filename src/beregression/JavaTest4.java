//IF-else loop
//stop printing the numbers in the array when you get the first multiple of 2

package beregression;

public class JavaTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {11, 73, 29, 88, 67, 82, 20, 16, 92};
		
		for(int i=0; i<arr1.length; i++)
		{
			if(arr1[i] % 2 == 0)
			{
				System.out.println(arr1[i] + " is the first multiple of 2 in the array");
				break;
			}
			
			else
			{
				System.out.println(arr1[i] + " is not a multiple of 2");
			}
		}
		
		System.out.print("The loop stopped as it encountered the first multiple of 2 in the given array");
	}

}
