package com.gen.Tools;

import java.math.BigInteger;

public class FactorialTools {
	long[] fact;
	long[] factInv;

	void initFact(int max) {
		fact = new long[max];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = i * fact[i - 1];
		}

	}

	void initFact(int max, int mode) {
		fact = new long[max];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = ((i % mode) * (fact[i - 1] % mode)) % mode;
		}
	}

	void FactInv(int mode) {
		factInv = new long[fact.length];
		for (int i = 0; i < fact.length; i++) {
			factInv[i] = modeInv(fact[i], mode);
		}
	}

	// mode = 10000000007
	long modeInv(long x, int mode) {
		return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(mode)).longValue();

	}
}
