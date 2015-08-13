package com.gen.datastructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_3 {
	/*
	 * write a method to replace all spaces with %20 using char [] (without
	 * using strings)
	 */

	public static final String fileDir = Constants.folderDir + "Problem_3";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream(fileDir));
		String str1;
		str1 = sc.nextLine();
		System.out.println(solve(str1.toCharArray()));
		sc.close();
	}

	private static char[] solve(char[] charArray) {
		// TODO Auto-generated method stub
		int spaceCounter = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				spaceCounter++;
			}

		}
		int indexer = 0;
		char[] result = new char[charArray.length + spaceCounter * 2];
		indexer = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != ' ')
				result[indexer++] = charArray[i];
			else {
				result[indexer++] = '%';
				result[indexer++] = '2';
				result[indexer++] = '0';
			}
		}
		return result;
	}

}
