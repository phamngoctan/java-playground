package com.tanpham.playaround.bit;

public final class BitUtils {
	
	private static final int SIZE_INT = 32;
	private static final int CHAR_BIT = 32;

	private BitUtils() {
		// Hiding the constructor for final class
	}
	
	public static int abs(int n) {
		int mask = n >> (SIZE_INT * CHAR_BIT - 1);
		System.out.println(Integer.toBinaryString(mask));
		System.out.println(Integer.toBinaryString(n + mask));
		System.out.println(Integer.toBinaryString((n + mask) ^ mask));
		return ((n + mask) ^ mask);
	}
	
	/**
	 * Main idea is that we set all the other bits to zero by & operator.<br/>
	 * So if the position with 1 value & with x, the result is 1 so x must be 1. Otherwise, x is 0.
	 */
	public static String fetchBitAtPosition(int number, int position) {
		int numberUsedForAndOperator = 1 << (position - 1);
		return (numberUsedForAndOperator & number) == 0 ? "0" : "1";
	}
	
}
