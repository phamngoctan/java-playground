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
	
}
