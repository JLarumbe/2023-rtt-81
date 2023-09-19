package areacomputer;

public class ConditionalOperators {
	public static void main(String[] args) {
		boolean c1 = false;
		boolean c2 = false;

		if (c1 || c2) {
			System.out.println("Either or both are true");
		}

		if (c1 && c2) {
			System.out.println("Both are true");
		}

		if (!c1 && !c2) {
			System.out.println("Neither are true");
		}

		int x = 10;

		if (x > 3 && x < 20) {
			System.out.println("X is between 3 and 20");
		}

		int y = 3;

		if (y % 2 == 1) {
			System.out.println("This is an odd number");
		} else {
			System.out.println("This is an even number");
		}
	}
}
