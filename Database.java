package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
	private ArrayList<String> Hashes;
	private ArrayList<String> UIDs;

	public Database() {
		Init();
	}

	private void Init() {
		try {
			BufferedReader H = new BufferedReader(
					new FileReader("C:\\Users\\Jr\\eclipse-workspace\\Experiment 1\\src\\main\\Hash.txt"));
			BufferedReader U = new BufferedReader(
					new FileReader("C:\\Users\\Jr\\eclipse-workspace\\Experiment 1\\src\\main\\UID.txt"));
			Hashes = new ArrayList<String>();
			UIDs = new ArrayList<String>();

			String Hash = H.readLine();
			while (Hash != null) {
				Hashes.add(Hash);
				Hash = H.readLine();
			}

			String UID = U.readLine();
			while (UID != null) {
				UIDs.add(UID);
				UID = U.readLine();
			}

			H.close();
			U.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found Error.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File Reading Error.");
			e.printStackTrace();
		}
	}

	public String getUID(int i) {
		return UIDs.get(i);
	}

	public String getHash(int i) {
		return Hashes.get(i);
	}

	public String getUIDs() {
		String toString = "";
		for (int i = 0; i < numberOfUIDs(); i++) {
			toString += getUID(i) + "\n";
		}
		return toString;
	}

	public String getHashes() {
		String toString = "";
		for (int i = 0; i < numberOfHashes(); i++) {
			toString += getHash(i) + "\n";
		}
		return toString;
	}

	public int numberOfUIDs() {
		return UIDs.size();
	}

	public int numberOfHashes() {
		return Hashes.size();
	}
}
