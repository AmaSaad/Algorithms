package com.gen.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LCS {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input"));
		while (sc.hasNext()) {
			String line1 = sc.nextLine();
			String line2 = sc.nextLine();
			performLCSAlgorithm(line1, line2);

		}

		sc.close();

	}

	enum inheritanceDirection {
		up, left, diag
	};

	private static void performLCSAlgorithm(String line1, String line2) {
		// TODO Auto-generated method stub

		int[][] m = new int[line1.length() + 1][line2.length() + 1];
		inheritanceDirection[][] dir = new inheritanceDirection[line1.length() + 1][line2
				.length() + 1];
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				int bounus = 0;
				if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
					bounus = 1;
				}
				if (m[i - 1][j] > Math.max(m[i][j - 1], m[i - 1][j - 1])) {
					m[i][j] = m[i - 1][j] + bounus;
					dir[i][j] = inheritanceDirection.up;

				} else if (m[i][j - 1] > m[i - 1][j - 1]) {
					m[i][j] = m[i][j - 1] + bounus;
					dir[i][j] = inheritanceDirection.left;

				} else {

					m[i][j] = m[i - 1][j - 1] + bounus;
					dir[i][j] = inheritanceDirection.diag;

				}

			}
		}
		for (int i = 0; i < dir.length; i++) {
			for (int j = 0; j < dir[0].length; j++) {
				System.out.print(dir[i][j] + " ");

			}
			System.out.println();

		}

	}
}
