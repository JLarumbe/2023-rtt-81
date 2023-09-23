package pa303_4_1;

public class Problem3 {
	public static void main(String[] args) {
		int x = 15;
		
		if(x < 10) {
			System.out.println("Less than 10");
		} else if(x > 10 && x < 20) {
			System.out.println("Between 10 and 20");
		}else if (x >= 20) {
			System.out.println("Greater than 10");
		}
	}
}
