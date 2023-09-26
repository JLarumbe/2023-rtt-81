package loops;

public class Loops {

	public static void main(String[] args) {
		int arraySize = 10;

		double[] doubleArray = new double[arraySize];

		String[] stringArray = new String[arraySize];
		stringArray[1] = "one";
		stringArray[2] = "two";
		stringArray[0] = "zero";
		stringArray[9] = "nine";

		// write a for loop that counts the number of nulls in the array
		// after the loop completes print that number
		int nullCount = 0;
		for (String value : stringArray) {
			if (value == null) {
				nullCount++;
			}
		}
		System.out.println("Number of nulls: " + nullCount);

		// write a for loop that tells me the location of the first null in the array
		// this is going to use the non-enhanced for loop
		int firstNull = 0;
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] == null) {
				firstNull = i;
				break;
			}
		}

		System.out.println("First null location is " + firstNull);

		// write a for loop that tells me how many values are not null
		// this is using an old style for loop with an array location

		int notNull = 0;

		for (String value : stringArray) {
			if (value != null) {
				notNull++;
			}
		}
		System.out.println("Number of null values in array is " + notNull);

		// write a for loop that tells me the last position of null in the array
		// by last null position we mean the position with the highest value
		// this looks at all 10 values in the array

		int lastNull = -1;
		for (int i = stringArray.length - 1; i >= 0; i--) {
			if (stringArray[i] == null) {
				lastNull = i;
				break;
			}
		}
		if (lastNull == -1) {
			System.out.println("The array does not have a null");
		} else {
			System.out.println("The last null of the array is in position " + lastNull);
		}

		// use letters.split(",") to make an array of letters
		// loop over the array and count the number of letters that are not vowels

		String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

		String vowels = "aeiou";

		String[] lettersArray = letters.split(",");

		int numberOfLetters = 0;
		for (String letter : lettersArray) {
			if (!vowels.contains(letter)) {
				numberOfLetters = numberOfLetters + 1;
			}
		}
		System.out.println("Number of letters enhanced: " + numberOfLetters);

	}

}
