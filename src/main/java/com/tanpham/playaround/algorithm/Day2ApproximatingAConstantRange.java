package com.tanpham.playaround.algorithm;

public class Day2ApproximatingAConstantRange {

	/*
	 * Implementation idea: using two pointers technique
	 * i: starting point
	 * j: end point
	 * 
	 * for (i -> length)
	 * maintain:
	 * max_length:
	 * freq: dem phan phoi arr
	 * distinct (should be less then 2) 
	 *   if higher --> delete (increase i) the freq until reach the target is less than 2, maintain distinct
	 *   else --> increase j, maintain distinct
	 * 
	 * finish the i: return max_length
	 * 
	 */
	public static int getMaxLength(int[] arr) {
		int j = 0;
		int maxIncreasedSubArray = 0;
		int curLength = 0;
		for (int i = 0; i < arr.length; i++) {
			
		}
		return 0;
	}

}
