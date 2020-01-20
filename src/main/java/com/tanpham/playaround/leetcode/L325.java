package com.tanpham.playaround.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L325 {

	public static int maxSubArrayLen(int[] nums, int k) {
//		int i = 0;
//		int j = 0;
//		int maxLength = 0;
//		int curValue = 0;
//		while (i < nums.length && j < nums.length) {
//			if (curValue == k) {
//				if (maxLength < i - j) {
//					maxLength = i - j;
//					System.out.println(maxLength);
//				}
//				i++;
//			} else if (curValue < k) {
//				if (nums[j] < 0) {
//					curValue -= nums[j];
//					j++;
//				} else {
//					curValue += nums[i];
//					i++;
//				}
//				
//			} else if (curValue > k) {
//				if (nums[j + 1] < 0) {
//					curValue += nums[i];
//					i++;
//				} else {
//					curValue -= nums[j];
//					j++;
//				}
//			}
//		}
		int maxLength = 0;
		int sum = 0;
		// Prefix sum array concept - integrate with map
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// To prevent putting the map.put(0, -1) in the first time
			if (sum == k) {
				maxLength = i + 1;
			} else if (map.containsKey(sum - k)) {
				maxLength = Math.max(maxLength, i - map.get(sum - k));
			}
			// This if just care the first time it meets the sum, don't need to update i because
			// we are finding the longest one
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxLength;
	}
	
}
