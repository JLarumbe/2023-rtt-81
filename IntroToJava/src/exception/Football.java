package exception;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Football implements Sport {
	int[] playerIDs = new int[11];

	Football() {
		Arrays.fill(playerIDs, 1);
		System.out.println("A new football team had been formed");
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

	void playerTransfer(int fee, int id) {
		for (int i = 1; i <= playerIDs.length; i++) {
			if (i == id && playerIDs[i - 1] == -1) {
				System.out.println("Player has already retired");
				break;
			} else if (i == id) {
				System.out.println("Player with id: {" + id + "} has been transfered with a fee of {" + fee + "}");
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("==============Football Constructor==============");
		Football football = new Football();

		System.out.println(Arrays.toString(football.playerIDs));

		System.out.println("==============calculateAvgAge Function==============");

		int[] age = { 23, 36, 34, 26, 22, 25 };

		System.out.println(Arrays.toString(age));

		football.calculateAvgAge(age);

		System.out.println("==============retirePlayer Function==============");

		football.retirePlayer(3);

		System.out.println(Arrays.toString(football.playerIDs));

		football.retirePlayer(3);

		System.out.println("==============playerTransfer Function==============");

		football.playerTransfer(400, 2);

		football.playerTransfer(500, 3);

	}
}
