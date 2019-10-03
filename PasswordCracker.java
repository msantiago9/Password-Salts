/**
 * Author Marjon Santiago
 * 27 September 2019
 * CSC 4222 - Cyber Security
 * Experiment 1
 */

package main;

import java.util.Scanner;

public class PasswordCracker {

	public static void main(String[] args) {
		System.out.println("What UID to Brute Force?");
		id = Integer.parseInt(input.nextLine());

		bruteForce(id - 1);

		retryQuery();
	}

	private static void bruteForce(int user) {

		String current;

		//goes through all possible combinations of passwords and salts
		//range of passwords: 0-1000 inclusive
		//range of salts: 0-100 inclusive
		for (int i = 0; i <= 1000; i++) {
			for (int j = 0; j <= 100; j++) {
				current = HashController.getHash(String.format("%04d", i) + String.format("%03d", j));
				HashController.compareHashes(database.getHash(user), current);
				if (HashController.hashesAreEqual(database.getHash(user), current)) {
					System.out.println("\nPassword: " + String.format("%04d", i) + "\nSalt: " + String.format("%03d", j));
					System.exit(0);
				}
			}
		}
	}

	private static void retryQuery() {
		System.out.println("Try again? (1 to continue, anything else to exit.)");

		int choice = 1;

		try {
			choice = Integer.parseInt(input.nextLine());
		} catch (NumberFormatException ex) {
			choice = 0;
		}

		if (choice == 1) {
			System.out.println("\n");
			main(null);
		} else {
			System.exit(0);
		}
	}

	private static Database database = new Database();
	private static Scanner input = new Scanner(System.in);
	private static int id = 1;
}
