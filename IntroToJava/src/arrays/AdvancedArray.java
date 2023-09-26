package arrays;

public class AdvancedArray {

	public static void main(String[] args) {
		double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
		
		double min = numbers[0], max = numbers[0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ];
		
		for(double number: numbers) {
			if(number < min) {
				min = number;
			} 
			
			if(number > max) {
				max = number;
			}
		}
		
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);

	}

}
