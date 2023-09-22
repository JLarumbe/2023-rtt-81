package bmi;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input weight in kilogram: ");
		double weight = sc.nextDouble();
		System.out.print("\nInput height in meters: ");
		double height = sc.nextDouble();
		// calculate bmi
		double BMI = weight / (height * height);
		// check range
		if (BMI < 18.5)
			System.out.println("Under weight");
		else if (BMI >= 18.5 && BMI < 25)
			System.out.println("Normal");
		else if (BMI >= 25 && BMI < 30)
			System.out.println("Overweight");
		else
			System.out.println("Obese");
		System.out.print("\nThe Body Mass Index (BMI) is " + BMI + " kg/m2");

	}

}
