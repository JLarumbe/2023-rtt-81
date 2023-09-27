package calculator;

import java.util.Scanner;

public class Calculator {
	int num1, num2;
	char op;

	void result(char op) {
		switch (op) {
		case '+':
			System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
			break;
		case '-':
			System.out.println(num1 + " - " + num2 + " = " + sub(num1, num2));
			break;
		case '*':
			System.out.println(num1 + " * " + num2 + " = " + mult(num1, num2));
			break;
		case '/':
			System.out.println(num1 + " / " + num2 + " = " + div(num1, num2));
			break;
		}
	}

	void userInput(Scanner sc) {
		System.out.print("Enter first number: ");

		num1 = sc.nextInt();

		System.out.print("Enter operator: ");

		op = sc.next().charAt(0);

		System.out.print("Enter second number: ");

		num2 = sc.nextInt();
	}

	int add(int num1, int num2) {
		return num1 + num2;
	}

	int sub(int num1, int num2) {
		return num1 - num2;
	}

	double mult(int num1, int num2) {
		return num1 * num2;
	}

	int div(int num1, int num2) {
		return num1 / num2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Calculator c = new Calculator();

		c.userInput(sc);

		c.result(c.op);
	}

}
