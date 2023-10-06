package exception;

import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n1 = 0, n2 = 0;

		try {
			n1 = readPositiveNumber(scanner);
			n2 = readPositiveNumber(scanner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("First number  : " + n1);
		System.out.println("Second number : " + n2);

		// Check whether k (for k = 2, 3, 4, and so on) is a common divisor
		// for n1 and n2, until k is greater than n1 or n2.

		// we are looking for where both numbers are divisible with no remainder

		// 5 and 15
		// 5 / 1 = 5 , 15 / 1 = 15 = Good !!!
		// 5 / 2 = 2.x , 15 / 2 = 7.x = No good
		// 5 / 3 = 1.x , 15 / 3 = 5 = No good
		// 5 / 4 = 1.x , 15 / 4 = 3.x = No good
		// 5 / 5 = 1 , 15 / 5 = 3 = Good !!!
		// 5 / 6 = 0.x ,
		// 5 / 7 = 0.x ,

		int gcd = 1;
		int min = Math.min(n1, n2);

		for (int k = 1; k <= min; k++) {
			if ((n1 % k == 0) && (n2 % k == 0)) {
				gcd = k;
			}
		}

		System.out.println("The gcd of " + n1 + " and " + n2 + " is " + gcd);
	}

	// make this catch an exception if the user enters letters
	// create a new GCDException that extends Exception and is thrown when a user
	// enters a non number
	private static int readPositiveNumber(Scanner scanner) throws Exception {
		int number = -1;
		while (number <= 0) {
			System.out.print("Enter a positive integer greater than 0 : ");
			try {
				number = scanner.nextInt();
			} catch (Exception e) {
				throw new Exception("Error : Must be a positive number");
			}

			if (number <= 0) {
				System.out.println();
			}
		}

		return number;
	}
}
