package practiceassignment;

import java.util.Arrays;

public class Task9 {

	public static void main(String[] args) {
		int[] arr = {4,2,9,13,1,0};
		
		Arrays.sort(arr);
		
		System.out.println("Array in ascending order: " + Arrays.toString(arr));
		
		System.out.println("Smallest number: "  + arr[0]);
		
		System.out.println("Biggest number: " + arr[arr.length-1]);
	}

}
