package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day2ApproximatingAConstantRange {

	static final int MAX = (int)1e5 + 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(getMaxLength(arr));
	}
	
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
		int[] freqArr = new int[MAX];
		for (int i = 0; i < arr.length; i++) {
			if (freqArr[arr[i]] == 0) {
				curLength++;
			}
			freqArr[arr[i]]++;
			while (j < arr.length && curLength > 2) {
				if (freqArr[arr[j]] == 1) {
					curLength--;
				}
				freqArr[arr[j]]--;
				j++;
			}
			maxIncreasedSubArray = Math.max(maxIncreasedSubArray, i - j + 1);
		}
		return maxIncreasedSubArray;
	}

}
