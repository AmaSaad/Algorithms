package com.gen.BitManipulation;

import javax.management.RuntimeErrorException;

public class Q2 {
	public static String conertToBinary(double d) {
		if (d >= 1)
			throw new RuntimeErrorException(null, "Error number >=1");
		StringBuilder b = new StringBuilder();
		double t = d;
		int i = 0;
		while (i < 32) {
			i++;
			t = t * 2;
			if ((int) t == 1) {
				b.append('1');
				t -= 1;
				if (t == 0)
					break;
			} else
				b.append('0');

		}
		if (t != 0)
			return "Error";
		return "0." + b.toString();
	}

	public static void main(String[] args) {
		System.out.println(conertToBinary(0.85));
	}
}
