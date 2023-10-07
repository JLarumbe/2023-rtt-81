package exception;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Cricket implements Sport {
	int[] playerIDs = new int[11];

	public Cricket() {
		System.out.println("A new cricket team has been formed");
		Arrays.fill(playerIDs, 1);
	}

	void calculateAvgAge(int[] age) {
		DecimalFormat df = new DecimalFormat("0.00");

		double avgAge = 0;

		for (int element : age) {
			avgAge += element;
		}

		avgAge = avgAge / age.length;

		System.out.println("The average age of the team is {" + df.format(avgAge) + "}");
	}

	void retirePlayer(int id) {
		for (int i = 1; i <= playerIDs.length; i++) {
			if (i == id && playerIDs[i - 1] == -1) {
				System.out.println("Player has already retired");
				break;
			} else if (i == id) {
				playerIDs[i - 1] = -1;
				System.out.println("Player with id: {" + id + "} has retired");
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("==============Cricket Constructor==============");
		Cricket cricket = new Cricket();

		System.out.println(Arrays.toString(cricket.playerIDs));

		System.out.println("==============calculateAvgAge Function==============");

		int[] age = { 23, 36, 34, 26, 22, 25 };

		System.out.println(Arrays.toString(age));

		cricket.calculateAvgAge(age);

		System.out.println("==============retirePlayer Function==============");

		cricket.retirePlayer(3);

		System.out.println(Arrays.toString(cricket.playerIDs));

		cricket.retirePlayer(3);

	}
}
