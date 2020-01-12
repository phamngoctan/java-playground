package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwoArray {
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
		Map<Integer, Integer> countByItem = new HashMap<>();
		int i = 0;
		while (i < arr.length && countByItem.size() < totalDiffValue) {
			countByItem.putIfAbsent(arr[i], 0);
			countByItem.put(arr[i], countByItem.get(arr[i]) + 1);
		}
		if (countByItem.size() >= totalDiffValue) {
			// FIXME: please
			return null;
		} else {
			return new Range(-1, -1);
		}
	}
	
}
