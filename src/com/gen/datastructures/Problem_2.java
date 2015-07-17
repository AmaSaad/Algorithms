package com.gen.datastructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.tools.sort.MyComparator;
import com.tools.sort.QuickSorter;
import com.tools.sort.Sorter;


public class Problem_2 {
	/*
	 * Given two strings , write a method to decide if one is a permutation of
	 * the other.
	 */
	public static final String fileDir = Constants.folderDir + "Problem_2";

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream(fileDir));
		String str1, str2;
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		System.out.println(solve_1(str1, str2));
		System.out.println(solve_2(str1, str2));

		sc.close();

	}

	private static boolean solve_2(String str1, String str2) {
		// TODO Auto-generated method stub
		Character[] ch1 = ArrayUtils.toObject(str1.toCharArray());
		Character[] ch2 = ArrayUtils.toObject(str2.toCharArray());
		if (ch1.length != ch2.length)
			return false;
		Sorter<Character> sorter = new QuickSorter<Character>(new MyComparator<Character>() {

			@Override
			public boolean Compare(Character e1, Character e2) {
				// TODO Auto-generated method stub
				return e1 < e2;
			}
		});
		sorter.sort(ch1);
		sorter.sort(ch2);
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean solve_1(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		// TODO Auto-generated method stub
		int[] count = new int[256];

		for (char a : str1.toCharArray())
			count[a]++;
		for (char a : str2.toCharArray())
			count[a]--;

		for (int i : count) {
			if (i != 0)
				return false;
		}
		return true;
	}

}
