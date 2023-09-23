package pa303_4_1;

public class Problem4 {
	public static void main(String[] args) {
		int x = 5;
		
		if(x < 10 || x > 20) {
			System.out.println("Out of range");
		} else if (x > 10 && x < 20) {
			System.out.println("In range");
		}
	}
}
