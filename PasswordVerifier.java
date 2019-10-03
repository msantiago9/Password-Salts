/**
 * Author Marjon Santiago
 * 27 September 2019
 * CSC 4222 - Cyber Security
 * Experiment 1
 */

package main;

import java.util.Scanner;

public class PasswordVerifier {

	public static void main(String[] args) {

		System.out.println("What is your UserID?");
		id = Integer.parseInt(input.nextLine());

		System.out.println("What is your Password?");
		pass = input.nextLine();

		System.out.println("What is the Salt?");
		salt = input.nextLine();

		//Generates a hash from the pass + salt.
		String generatedHash = HashController.getHash(pass + salt);
		
		//Compares that hash to the hash in the database for the specific UserID
		HashController.compareHashes(database.getHash(id - 1), generatedHash);

		retryQuery();

	}

	private static void retryQuery() {
		System.out.println("Try again? (1 to continue, anything else to exit.)");
		
		int choice = 1;
		
		try {
			choice = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException ex) {
			choice = 0;
		}
		
		if(choice == 1) {
			System.out.println("\n");
			main(null);
		}
		else {
			System.exit(0);
		}
	}

	private static Database database = new Database();
	private static Scanner input = new Scanner(System.in);

	private static int id = 0;
	private static String pass = "";
	private static String salt = "";
}