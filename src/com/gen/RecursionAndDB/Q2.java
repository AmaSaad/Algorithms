package com.gen.RecursionAndDB;


public class Q2 {
	static int i=0;
	public static int count(int xi, int yi, int xt, int yt, String path) {
		if (xi > xt || yi > yt) {
			return 0;
		}
		if (xi == xt && yi == yt) {
			System.out.println((++i)+"- "+path.toString() + "(" + xt + "," + yt + ")");
			return 1;
		}
		path += ("(" + xi + "," + yi + ") - ");
		return count(xi + 1, yi, xt, yt, path)
				+ count(xi, yi + 1, xt, yt, path);

	}

	public static void main(String[] args) {
		System.out.println(count(0, 0, 5, 5, ""));
	}
}
