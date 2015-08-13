package com.gen.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PieceOfWood {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input"));
		int line = 0;
		int[] c = null;
		while (sc.hasNext()) {
			line++;
			int num = sc.nextInt();
			if (line == 1) {
				c = new int[num];

			} else {
				c[line - 2] = num;
			}

		}
		applyAlgorithmIterative(c);
	
		// applyAlgorithm(c);
		sc.close();
	}

	public static void applyAlgorithmRecursive(int[] c) {
		int[][] kTracker = new int[c.length + 1][c.length + 1];
		int revenue = getRevenueOf(c, 0, c.length, kTracker);
		track(kTracker, 0, c.length);
		System.out.println();
		System.out.println("total revinue = " + revenue);
	}
	
	//M[0][3]=M[0][1]+M[1][3]
	private static void applyAlgorithmIterative(int[] c) {
		// TODO Auto-generated method stub
		int[][] tracker = new int[c.length + 1][c.length + 1];
		int[][] m = new int[c.length + 1][c.length + 1];
		for (int i = 0; i < m.length; i++) {
			for (int j = i+1; j < m.length; j++) {
				int bestCost = c[j - i - 1];
				int bestK = 0;// 0 means no split
				tracker[i][j] = 0;
				for (int k = i + 1; k < j; k++) {
					int candScore = c[j - k - 1] + m[i][k];
					if (bestCost < candScore) {
						bestCost = candScore;
						bestK = k;
					}
				}
				m[i][j] = bestCost;
				tracker[i][j] = bestK;

			}
		}

		int i = 0;
		int j = m.length - 1;
		track(tracker, i, j);
		System.out.println();
		System.out.println("total revinue = " + m[0][m.length-1]);
	}

	private static int getRevenueOf(int[] c, int from, int to, int[][] kTracker) {
		int revinue = c[to - from - 1];
		int splitK = 0;
		for (int k = from + 1; k < to; k++) {
			int candRevinue = getRevenueOf(c, from, k, kTracker)
					+ getRevenueOf(c, k, to, kTracker);
			if (candRevinue > revinue) {
				revinue = candRevinue;
				splitK = k;
			}
		}
		kTracker[from][to] = splitK;

		return revinue;
	}

	private static void track(int[][] tracker, int i, int j) {
		// TODO Auto-generated method stub
		int k = tracker[i][j];
		if (k == 0)
			System.out.println("sell from " + i + " to " + j);
		else {
			track(tracker, i, k);
			track(tracker, k, j);

		}

	}

}
