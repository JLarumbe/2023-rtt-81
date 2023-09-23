package stringexamples;

public class ContainsExample {

	public static void main(String[] args) {
		String str1 = "Learn Java";
		Boolean result;

		result = str1.contains("Java");
		System.out.println(result);

		result = str1.contains("Python");
		System.out.println(result);

		result = str1.contains("");

		System.out.println(result);
	}

}
