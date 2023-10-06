package exception;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		ExceptionExample ee = new ExceptionExample();
		try {
			// this will cause a null pointer exception
			// String x = null;
			// x.toUpperCase();

			ee.readNumber();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// when you add throws Exception to a method it forces a checked exception
	public void readNumber() throws Exception {
		Scanner scanner = new Scanner(System.in);

		// try to make it so the user has to keep trying until they enter a number
		// hint : use a while loop and a break;
		while (true) {
			System.out.println("Please enter a number: ");
			// this can throw an unchecked exception
			int x = scanner.nextInt();
			
			
		}
	}
}