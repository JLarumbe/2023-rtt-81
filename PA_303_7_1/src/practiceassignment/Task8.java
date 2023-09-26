package practiceassignment;

import java.util.Arrays;

public class Task8 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};

		int temp = arr[0];
		
		arr[0] = arr[arr.length / 2];
		
		arr[arr.length / 2] = temp;
		
		System.out.println(Arrays.toString(arr));
	}

}
