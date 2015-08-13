package com.gen.BitManipulation;

public class Q3 {
	public static void main(String[] args) {
		int n = 4;
		int nextSmallest = getSmallest(n);
		System.out.println(nextSmallest);
		//
		int nextBigger = getBigger(n);
		System.out.println(nextBigger);
	}

	private static int getSmallest(int n) {
		int oneIndex =getNearestFromOne(n, 0);
		int zeroIndex = oneIndex - 1;
		int nextSmallest = swap(zeroIndex, oneIndex, n);
		return nextSmallest;
	}

	private static int getNearestOne2Index(int n, int lowerBoundIndex) {

		boolean findZero = false;
		int index = 0;
		while (n % 2 == 0 || index < lowerBoundIndex || !findZero) {
			if (n % 2 == 0)
				findZero = true;
			index++;
			n /= 2;
		}
		// TODO Auto-generated method stub
		return index;
	}

	private static int getBigger(int n) {
		int zeroIndex;
		int oneIndex;
		oneIndex = getNearestOneIndex(n, 0);
		zeroIndex = getNearestZeroIndex(n, oneIndex + 1);
		int nextBigger = swap(zeroIndex, oneIndex, n);
		return nextBigger;
	}

	private static int swap(int zeroIndex, int oneIndex, int n) {
		n += Math.pow(2, zeroIndex);
		n -= Math.pow(2, oneIndex);

		// TODO Auto-generated method stub
		return n;
	}

	public static int getNearestFromOne(int n, int offset) {
		int t = n >> offset;
		int index = offset;
		while ((t & 1) != 1) {
			index++;
			t >>= 1;
		}
		return index;
	}
	public static int getNearestFromZero(int n, int offset) {
		int t = n >> offset;
		int index = offset;
		while ((t & 1) != 0) {
			index++;
			t >>= 1;
		}
		return index;
	}
	private static int getNearestOneIndex(int n, int lowerBoundIndex) {

		int index = 0;
		while (n % 2 == 0 || index < lowerBoundIndex) {
			index++;
			n /= 2;
		}
		// TODO Auto-generated method stub
		return index;
	}

	private static int getNearestZeroIndex(int n, int lowerBoundIndex) {
		int index = 0;
		while (n % 2 == 1 || index < lowerBoundIndex) {
			index++;
			n /= 2;
		}
		// TODO Auto-generated method stub
		return index;
	}
}
