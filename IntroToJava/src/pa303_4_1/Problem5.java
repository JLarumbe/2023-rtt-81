package pa303_4_1;

import java.util.Scanner;

public class Problem5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("Score out of range");
			System.exit(1);
		}

		if (score >= 90.0) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}
