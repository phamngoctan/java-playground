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
	
	/**
	 * Main idea:<br/>
	 * Number is power of 2 when it’s binary representation has only one 1 and that too as the left most bit<br/>
	 * To check it, we apply an approach: <br/>
	 * Suppose we have to check for number 8. 8= 1000 and 8 – 1 = 7 = 0111 <br/>
	 * if we AND the number with number-1, we will get 0, as in the above case.
	 */
	public static boolean checkAPowerOfTwo(int number) {
		return (number & (number - 1)) == 0;
	}
	
	/**
	 * Given an array of numbers. Array has only one element which is alone. All other elements appear in pair. <br/>
	 * Find that one element with missing pair <b>in O(1) extra space</b> <br/><br/>
	 * 
	 * Solution: XOR of element with itself results value zero. So if we XOR all item, the missing pair item will be the result.
	 */
	public static int findMissingPairItem(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new RuntimeException("Wrong input array");
		}
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = result ^ arr[i];
		}
		return result;
	}

	/**
	 * There are two approaches: 
	 * <li>Firstly, using shift left operator</li> 
	 * <li>Secondly, using an algorithm named "Brian Kernighan’s Algorithm" <br/>
	 * 		It states that if we perform AND operation of the number with number-1, we actually un-set it’s rightmost bit. So keep on doing this until number becomes zero
	 * </li>
	 */
	public static int findNumberOfSetBits(int number) {
		int counter = 0;

		// first approach
		while (number != 0) {
			number = number >> 1;
			counter++;
		}
		
		// second approach
//		while (number > 0) {
//            number &= (number - 1);
//            counter++; 
//        }
		return counter;
	}
	
}
