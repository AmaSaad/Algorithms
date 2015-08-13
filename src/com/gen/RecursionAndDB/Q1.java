package com.gen.RecursionAndDB;

public class Q1 {
	public static int count(int n) {
		return count(1, n) + count(2, n) + count(3, n);

	}


	private static int count(int steps, int n) {
		if (steps > n)
			return 0;
		if (steps == n)
			return 1;
		int reminder = n - steps;
		return count(1, reminder) + count(2, reminder) + count(3, reminder) ;

	}

	public static void main(String[] args) {
		System.out.println(count(8));
	}
}
