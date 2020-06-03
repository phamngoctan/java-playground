package com.tanpham.playaround.algorithm;

import java.util.Scanner;

/*
 * In this exercise, we don't need to consider to remove from the last position. 
 * Because we already stop at the first time we figure out the item that make the sub
 * array fully contains K distinguished items
 */
public class Day2Array {
	static class Range {
		int from;
		int to;
		public Range(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public String toString() {
			return "Range [from=" + from + ", to=" + to + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int distinguishedItem = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Range position = getPosition(arr, distinguishedItem);
		System.out.println(position.from + " " + position.to);
	}
	
	/*
	 * implementation idea:::
	 * step 1: find sub arr enough k distinguished items
	 * step 2: check if in the found out sub arr, if it has sub_arr has k distinguished items
	 *         how to:
	 *           check from the left until only has k - 1 (bo dan)
	 *           example: 1 1 2 2 3
	 *                   -> 1 2 2 3
	 *                   -> cannot remove anymore, 
	 *                   ==> 1 2 2 3 is a sub-arr has k items, return it ;) =))
	 *                   
	 * another technique:
	 * Dem phan phoi???
	 * frequency hash table key => value with value => total repeat times
	 * instead of using array, use hash table to count & use it to find the sub-arr has k items inside that sub-arr has
	 * otherwise, return the found sub-arr
	 * 
	 * Two separate for or while, whatever, it O(2n) -> O(n)
	 * 
	 */
	public static Range getPosition(int[] arr, int totalDiffValue) {
		int[] frequencyArr = new int[100001];
		int countDiffItems = 0;
		int totalItems = 0;
		for (int i = 0; i < arr.length; i++) {
			if (frequencyArr[arr[i]] == 0) {
				countDiffItems++;
			}
			frequencyArr[arr[i]] += 1;
			totalItems++;
			if (countDiffItems >= totalDiffValue) {
				break;
			}
		}
		
		if (countDiffItems < totalDiffValue) {
			return new Range(-1, -1);
		}
		
		for(int i = 0; i < frequencyArr.length; i++) {
			if (frequencyArr[arr[i]] == 1) {
				return new Range(i + 1, totalItems);
			} else {
				frequencyArr[arr[i]]--;
			}
		}
		return new Range(-1, -1);
	}
	
}
