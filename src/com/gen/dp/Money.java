package com.gen.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Money {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input"));
		int line = 0;
		int[] currencies = null;
		int money = 0;
		while (sc.hasNext()) {
			line++;
			int num = sc.nextInt();
			if (line == 1) {
				money = num;
			} else if (line == 2) {
				currencies = new int[num];

			} else {
				currencies[line - 3] = num;
			}

		}
		// applyRecursiveAlgorithm(currencies, money);
		applyAlgorithmIterativly(currencies, money);
		System.out.println();
		applyRecursiveAlgorithm(currencies, money);

		sc.close();
	}

	private static void applyRecursiveAlgorithm(int[] currencies, int money) {
		// TODO Auto-generated method stub
		Hashtable<Integer, Integer[]> tracker = new Hashtable<Integer, Integer[]>();

		int minCountOfPapers = getMinCountOfPapers(currencies, money, tracker);
		System.out.println(minCountOfPapers);
		backTrace(tracker, money, currencies);
	}

	public static void applyAlgorithmIterativly(int[] currencies, int money) {
		int[] m = new int[money];
		for (int i = 0; i < m.length; i++) {
			int minCurrCount = Integer.MAX_VALUE;
			int minJ = -1;
			int currentMoney = i + 1;
			for (int j = 0; j < currencies.length; j++) {
				int curr = currencies[j];
				if (curr > currentMoney)
					continue;
				int currCount = currentMoney / curr;
				if (currCount < minCurrCount) {
					minCurrCount = currCount;
					minJ = j;

				}

			}
			m[i] = minJ;
		}
		backtrack(m, currencies);

	}

	private static void backtrack(int[] m, int[] currencies) {
		int money=m.length;
		int rem=money;
		while(rem!=0){
			int curr=currencies[m[rem-1]];
			int count =rem/curr;
			System.out.println(count + " from " + curr);
			rem=rem-curr*count;
		}
		// TODO Auto-generated method stub
		
	}

	private static void backTrace(Hashtable<Integer, Integer[]> tracker,
			int money, int[] currencies) {
		// TODO Auto-generated method stub
		if (money == 0)
			return;

		Integer[] m = tracker.get(money);
		int curr = currencies[m[0]];
		int count = m[1];
		int rem = money - curr * count;
		System.out.println(count + " from " + curr);
		backTrace(tracker, rem, currencies);
	}

	private static int getMinCountOfPapers(int[] currencies, int money,
			Hashtable<Integer, Integer[]> tracker) {
		if (money == 0)
			return 0;

		int minCount = Integer.MAX_VALUE;
		int minCurrCount = Integer.MAX_VALUE;
		int minCurrI = -1;
		for (int i = 0; i < currencies.length; i++) {
			int curr = currencies[i];
			if (curr > money)
				continue;
			int currCount = money / curr;

			int rem = money - currCount * curr;
			int count = currCount
					+ getMinCountOfPapers(currencies, rem, tracker);
			if (count < minCount) {
				minCount = count;
				minCurrI = i;
				minCurrCount = currCount;
			}
		}
		// we now want to track (Currency (i),count of papers taken by that
		// currency (currCount),
		// and money
		tracker.put(money, new Integer[] { minCurrI, minCurrCount });
		return minCount;
	}

}
