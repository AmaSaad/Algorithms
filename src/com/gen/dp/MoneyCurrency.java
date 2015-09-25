package com.gen.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MoneyCurrency {

	public static int solve1(int m) {
		// memoization is accepted here
		for (int i = 0; i < curr.length; i++) {
			if (curr[i] == m)
				return 1;
			if (curr[i] > m)
				break;
		}
		int count = 0;
		int minCount = Integer.MAX_VALUE;

		for (int i = 0; i < curr.length; i++) {
			if (curr[i] > m)
				break;

			count = 1 + solve1(m - curr[i]);
			if (count < minCount)
				minCount = count;

		}
		return minCount;

	}

	public static int solve2(int m) {
		int[] dp = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			int index = Arrays.binarySearch(curr, i);
			if (index >= 0) {
				dp[i] = 1;
			}
		}
	}

	static int curr[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		curr = new int[n];
		for (int i = 0; i < n; i++) {
			curr[i] = sc.nextInt();
		}
		Arrays.sort(curr);

		int M = sc.nextInt();
		System.out.println(solve(M));
		sc.close();
	}

}
