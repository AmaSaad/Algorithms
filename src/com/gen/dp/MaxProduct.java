package com.gen.dp;

import java.util.Scanner;

public class MaxProduct {
	public static int solve_1(int S, int K) {
		if (K > S)
			throw new RuntimeException("Invalid K value");
		int h = (int) Math.ceil((double) S / (double) K);
		int mul = 1;
		int rem = S;
		while (rem > 0) {
			mul *= h;

			rem -= h;
			if (rem - h < 0) {
				h = rem;
			}
		}
		return mul;

	}

	////
	static int[][] tracker;

	public static int solve_2(int S, int K) {
		tracker = new int[S+1][K+1];

		int max = solve_2_rec(S, K);

		return max;

	}

	private static int solve_2_rec(int s, int k) {
		if (k > s)
			throw new RuntimeException("Invalid K value");
		if (k == 1)
			return s;
		int maxLimit = s - k + 1;
		int MaxProduct = 0;
		int product = 0;
		int i_max = 0;
		for (int i = 1; i <= maxLimit; i++) {
			product = i * solve_2_rec(s - i, k - 1);
			if (product > MaxProduct) {
				MaxProduct = product;
				i_max = i;

			}
		}
		tracker[s][k] = i_max;
		return MaxProduct;
	}

	public static int solve_3(int S, int K) {
		int[][] dp = new int[S + 1][K + 1];
		dp[0][0] = 1;

		// for (int s = 0; s < S; s++)
		// dp[s][0] = 1;

		for (int s = 1; s <= S; s++) {
			for (int k = 1; k <= s && k <= K; k++) {
				int maxLimit = s - k + 1;
				int maxProd = 0, prod = 0;
				for (int t = 1; t <= maxLimit; t++) {
					prod = t * dp[s - t][k - 1];
					if (prod > maxProd)
						maxProd = prod;
				}
				dp[s][k] = maxProd;

			}
		}
		return dp[S][K];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve_1(s, k));
		System.out.println(solve_2(s, k));
		System.out.println(solve_3(s, k));

		sc.close();
	}
}
