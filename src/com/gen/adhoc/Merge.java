package com.gen.adhoc;

public class Merge {
	public static String[] merge(String[] a, String[] b, int bValidSize) {

		int i = a.length - 1;
		int j = bValidSize - 1;
		int k = b.length - 1;

		while (true) {

			if (i >= 0 && j >= 0) {
				if (Integer.parseInt(a[i])>Integer.parseInt(b[j])) {
					b[k--] = a[i--];
				} else {
					b[k--] = b[j--];

				}
			} else if (i >= 0) {

				b[k--] = a[i--];

			} else if (j >= 0) {
				b[k--] = b[j--];

			} else
				break;

		}

		return b;
	}
	public static void main(String[] args) {
		String []a=new String [] { "1", "2", "3" };
		String []b=new String [] { "1", "3", "5", "6", null, null, null };
		b=merge(a, b, 4);
		for(String t:b)System.out.println(t);
	}
}
