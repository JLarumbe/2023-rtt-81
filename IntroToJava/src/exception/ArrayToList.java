package exception;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToList implements MyList {
	ArrayList<String> arrayToList;

	public ArrayToList() {
		arrayToList = new ArrayList<>();
	}

	public void convert(String[] a) {
		for (int i = 0; i < a.length; i++) {
			arrayToList.add(a[i]);

			System.out.println("I have added the string: {" + a[i] + "} at the index: " + i);
		}
	}

	public void replace(int idx) {
		System.out.println("I have replaced the string: {" + arrayToList.get(idx) + "} with a null string");

		arrayToList.set(idx, "");
	}

	public ArrayList<String> compact() {
		ArrayList<String> newArray = new ArrayList<>();

		for (String word : arrayToList) {
			if (!word.equals("")) {
				newArray.add(word);
			}
		}

		return newArray;
	}

	public static void main(String[] args) {
		ArrayToList obj = new ArrayToList();

		String[] arr = { "This", "class", "is", "boring" };

		System.out.println("=======================Convert Function=======================");
		
		System.out.println("Array: " + Arrays.toString(arr));

		obj.convert(arr);

		System.out.println(obj.arrayToList);

		System.out.println("=======================Replace Function=======================");

		obj.replace(0);
		
		obj.replace(2);

		System.out.println(obj.arrayToList);

		System.out.println("=======================Compact Function=======================");

		System.out.println(obj.compact());
	}
}
