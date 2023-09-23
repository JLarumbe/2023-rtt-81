package stringexamples;

public class StringComparisonExample {

	public static void main(String[] args) {
		String s1 = "PerScholas";
		String s2 = "PerScholas";
		String s3 = new String("PerScholas");
		String s4 = "Teksystem";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));

		// -----------------------------------//

		s1 = "Perscholas";
		s2 = "Perscholas";
		s3 = new String("Perscholas");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		// -----------------------------------//

		s1 = "Perscholas";
		s2 = "Perscholas";
		s3 = "Perschola";
		s4 = "PerscholasX";
		System.out.println(s1.compareTo(s2)); 
		System.out.println(s1.compareTo(s3)); 
		System.out.println(s1.compareTo(s4));

	}

}
