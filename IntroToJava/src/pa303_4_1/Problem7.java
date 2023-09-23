package pa303_4_1;

import java.util.Scanner;

public class Problem7 {
	static void displayMenu() {
		System.out.println("1.) Single");
		System.out.println("2.) Married Filing Jointly / Qualifying Widow(er)");
		System.out.println("3.) Married Filing Sperately");
		System.out.println("4.) Head of Household");
		System.out.print("Enter your filing status: ");
	}

	public static void main(String[] args) {
		int filingStatus = 0, income = 0;

		Scanner sc = new Scanner(System.in);

		displayMenu();

		filingStatus = sc.nextInt();

		System.out.print("Enter your income: ");

		income = sc.nextInt();
		
		switch(filingStatus) {
		case 1:
			
		}
	}
}
