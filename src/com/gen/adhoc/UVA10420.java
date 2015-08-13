package com.gen.adhoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		HashMap<String, Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			String[] tockens = line.split(" ");
			String countary = tockens[0];
			if (hash.containsKey(countary)) {
				hash.put(countary, hash.get(countary) + 1);

			} else {
				hash.put(countary, 1);
			}
		}
		String[] keys = (String[]) hash.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		for (String countary : keys) {
			System.out.println(countary + " " + hash.get(countary));

		}

		sc.close();

	}

}
