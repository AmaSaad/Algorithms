package com.gen.BitManipulation;

public class Q1 {
	public static int enter(int n, int m, int i, int j) {
//prepare m.
		int d = j - i + 1;
		int mask = (int) (Math.pow(2, d) - 1);
		m = m & mask;
		m=m<<i;
//prepare n
		mask=mask<<i;
		mask=~mask;
		n=n&mask;
		//perform bitwise or`
		n = n | m;
		return n;
	}
public static void main(String[] args) {
	int n=1024;
	int m=19;
	System.out.println(enter(n, m, 2, 6));
}
}
