package com.gen.dp;

import java.util.Scanner;

public class LIS {
	static int a[];
	static int dp[][];

	public static int calculate_1() {

		return calculate_1(0, -1);
	}

	public static int calculate_1(int index, int prev_index) {
		// Memorization is
		// accepted here
		if (a.length <= index)
			return 0;
		if (prev_index == -1)
			return calculate_1(index + 1, index) + 1;
		int current = a[index];
		int prev = a[prev_index];
		int option2, option1 = calculate_1(index + 1, prev_index);
		if (current > prev) {
			option2 = calculate_1(index + 1, index) + 1;
			return Math.max(option1, option2);
		}

		return option1;
	}

	public static int calculate_2() {
		// db[index][prev] = length
		int dp[][] = new int[a.length][a.length];

		for (int i = 0; i < a.length; i++)
			dp[i][i] = 1;

		int max[] = new int[a.length];
		
		max[0] = 1;
		for (int i = 1; i < a.length; i++) {
			max[i] = 1;

			for (int prev = 0; prev < i; prev++) {
				int current_val = a[i];
				int prev_val = a[prev];
				if (current_val > prev_val) {
					dp[i][prev] = max[prev] + 1;

				} else {

					dp[i][prev] = max[prev];
				}
				if (dp[i][prev] > max[i])
					max[i] = dp[i][prev];

			}

		}
		return dp[a.length - 1][a.length - 2];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(calculate_1());
		System.out.println(calculate_2());

		sc.close();

	}
}
