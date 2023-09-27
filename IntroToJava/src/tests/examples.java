package tests;

public class examples {
	public static void main(String[] args) {
		String x = "abcxyz";
		
		String y =  x.toUpperCase();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc");
		buffer.append("xyz");
		
		String sub = buffer.substring(0, 3);
		
		buffer.insert(3, "123");
		
		System.out.println(buffer.toString());
	}
}
