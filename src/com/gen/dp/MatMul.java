package com.gen.dp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatMul {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("input"));
		int numCount = 0;
		int length = 0;
		int[] C = null;
		while (sc.hasNext()) {

			int num = sc.nextInt();
			if (numCount == 0) {
				length = num;

				C = new int[length];
			} else {
				C[numCount - 1] = num;
			}

			numCount++;
		}
		int[][][] KM = getKMat(C);
		int K[][] = KM[0];
		int[][] M = KM[1];
		int i = 0;
		int j = M.length - 1;
		print(M, K, i, j);
		sc.close();
	}

	private static void print(int[][] m, int[][] k, int i, int j) {
		if(i>=j)return;
		// TODO Auto-generated method stub
		if (j == i + 1) {
			System.out.println("(" + i + "," + j + ")");
			return;
		}
		System.out.println("(" + i + "," + k[i][j] + "," + j + ")");
		print(m, k, i, k[i][j]);
		print(m, k, k[i][j]+1, j);

	}

	private static int[][][] getKMat(int[] C) {
		// TODO Auto-generated method stub
		int[][] M = new int[C.length][C.length];
		int[][] K = new int[C.length][C.length];
		for (int i = 0; i < C.length; i++) {
			for (int j = i + 1; j < C.length; j++) {
				if (j == i + 1) {
					M[i][j] = C[i];
					continue;
				}
				int min = Integer.MAX_VALUE;
				int k = i + 1;
				int minK = k;
				while (k < j) {
					int sum = M[i][k] + M[k][j];
					if (min > sum) {
						min = sum;
						minK = k;
					}

					k++;

				}
				M[i][j] = min;
				K[i][j] = minK;

			}
		}
		return new int[][][] { K, M };
	}
}
