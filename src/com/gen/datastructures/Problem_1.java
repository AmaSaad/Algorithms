package com.gen.datastructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_1 {
	/*
	 * implement an algorithm to determine if a string has all unique
	 * characters. (with additional datastrucure and without)
	 */
	public static final String fileDir = Constants.folderDir + "Problem_1";

	private static boolean solve_with_ds(String line) {
		// TODO Auto-generated method stub
		char[] chars = line.toCharArray();
		boolean[] check = new boolean[256];
		for (int n : chars) {
			if (check[n])
				return false;
			check[n] = true;

		}
		return true;
	}

	private static boolean solve_without_ds(String line) {
		// TODO Auto-generated method stub
		char[] chars = line.toCharArray();
		long check = 0;
		for (char n : chars) {
			if (n < 'a' || n > 'z')
				throw new RuntimeException("\nCharacter " + n
						+ " is not acceptable to be solved with this algorithm!! only a-z A-Z are the acceptable characters");

			int t = n - 'a';
			long mask = (1 << t);
			long result = mask & check;
			if (result != 0) // the char in index a found before
				return false;
			check |= (1 << t);

		}
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream(fileDir));
		long time = 0;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			boolean result = false;
			time=System.currentTimeMillis();
			result = solve_with_ds(line);
			time=System.currentTimeMillis()-time;
			System.out.println("With DS: "+result+" Time = "+time);
			
			time=System.currentTimeMillis();
			result = solve_without_ds(line);
			time=System.currentTimeMillis()-time;
			System.out.println("Without DS: "+result+" Time = "+time);

		}

		sc.close();
	}

}
