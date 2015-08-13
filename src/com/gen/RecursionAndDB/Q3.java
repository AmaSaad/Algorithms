package com.gen.RecursionAndDB;

public class Q3 {
	public static int searchSorted(int[] A, int from, int to) {
		if (from == to) {
			if (A[from] == from)
				return from;
			else
				return -1;

		}
		if (from > to)
			return -1;
		int mid = (to - from + 1) / 2;
		if (A[mid] == mid)
			return mid;
		if (mid < A[mid])
			return searchSorted(A, from, mid - 1);
		else
			return searchSorted(A, mid + 1, to);
	}

	public static void main(String[] args) {
		int[] A = new int[] { 2, 3, 5, 6, 8, 9, 11, 12, 12, 12, 12, 12, 12, 12,
				12, 12, 12, 12, 12, 12 };
		System.out.println(searchSorted(A, 0, A.length - 1));
	}
}
