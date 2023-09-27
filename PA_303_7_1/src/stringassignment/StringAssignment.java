package stringassignment;

public class StringAssignment {

	public static void main(String[] args) {
		// find the position of the first space in the string
		String example = "This is an example";

		int firstSpace = example.indexOf(" ");

		System.out.println("First Space: " + firstSpace);
		// find the position of the last space in the string
		// substring of the characters between the first and last space of the string

		int lastSpace = example.lastIndexOf(" ");
		System.out.println("Last Space: " + lastSpace);

		// do the same thing to find the substring of the first and last vowel of the
		// string
		int firstVowel = -1;
		String vowels = "aeiou";

		for (int i = 0; i < example.length(); i++) {
			if(vowels.indexOf(example.charAt(i)) != -1) {
				firstVowel = i;
			}
		}
		
		System.out.println("First Vowel: " + firstVowel);
		// use the string.charAt function and use a for loop to loop over the entire
		// string
		// and print out each character with a new line after it.
		// you need to use the string.length() function also
		for (int i = 0; i < example.length(); i++) {
			System.out.println(example.charAt(i));
		}

		// using only indexOf(" ") print the substring that contains the word "is"
		// use 2 substrings to do this.
		int firstIndex = example.indexOf(" ");
		int lastIndex = example.lastIndexOf('s');
		
		String sub = example.substring(firstIndex+1, lastIndex+1);
		
		System.out.println(sub);

	}

}
