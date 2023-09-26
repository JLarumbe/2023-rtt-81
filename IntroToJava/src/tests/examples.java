package tests;

public class examples {
	public static void main(String[] args) {
		String[] stringArray = new String[10];
		int c = 0;
		
		stringArray[0] = "t";
		stringArray[1] = "t";
		stringArray[2] = "t";
		
		for(int i = 0; i < stringArray.length; i++) {
			if(stringArray[i] == null) {
				c = i;
			}
		}
		
		System.out.println(c);
	}
}
