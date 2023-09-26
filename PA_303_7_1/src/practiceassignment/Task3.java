package practiceassignment;

import java.util.Arrays;

public class Task3 {

	public static void main(String[] args) {
		String[] arr = {"red", "green", "blue", "yellow"};
		
		System.out.println("Array length: " + arr.length);
		
		String[] copyOfArr = arr.clone();
		
		System.out.println("Original Array: " + Arrays.toString(arr));
		
		System.out.println("Duplicate Array: " + Arrays.toString(copyOfArr));
	}

}
