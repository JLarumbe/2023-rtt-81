package practiceassignment;

import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many favorite things do you have? ");

		int numOfFavThings = sc.nextInt();

		String[] arr = new String[numOfFavThings];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter your thing: ");

			String choice = sc.next();

			sc.nextLine();

			arr[i] = choice;
		}

		System.out.println("Your favorite things are: ");

		for (String things : arr) {
			System.out.print(things + " ");
		}
	}

}
