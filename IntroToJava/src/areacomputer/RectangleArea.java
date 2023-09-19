package areacomputer;

import java.util.Scanner;

public class RectangleArea {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the height: ");
		int height = sc.nextInt();
		
		System.out.print("Enter the width: ");
		int width = sc.nextInt();
		
		int area = height * width;
		
		System.out.println("The area of the rectangle is " + area);

	}

}
