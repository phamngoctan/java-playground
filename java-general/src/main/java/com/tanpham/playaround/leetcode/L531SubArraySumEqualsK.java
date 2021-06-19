package com.tanpham.playaround.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L531SubArraySumEqualsK {
	/**
	 * 
[10, 2, -2, -20, 10, 10]
k = 10

---
0, 1

10, 1 --> count = 0 + 1, --> 1
12, 1
10, 1 --> count = 1 + counter.get(0) --> 2
-10, 1 
0, 2 & -10, 2--> count = 2 + counter.get(-10) --> 3
10, 2 --> count = 3 + counter.get(10) --> 5

	 */
	public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            //System.out.println("(" + curSum + ","+increasedI+")");
            if (counter.containsKey(curSum - k)) {
            	//System.out.println("count will be added for period " + curSum + "-" + k + ": " + counter.get(curSum - k));
            	total += counter.get(curSum - k);
            }
            
            int increasedI = 1;
            if (counter.containsKey(curSum)) {
            	increasedI = counter.get(curSum) + 1;
                counter.put(curSum, increasedI);
            } else {
            	counter.put(curSum, 1);
            }
            
        }
        return total;
    }
	public static void main(String[] args) {
//		System.out.println(new L531SubArraySumEqualsK().subarraySum(new int[] {1, 2, 3}, 3));
//		System.out.println(new L531SubArraySumEqualsK().subarraySum(new int[] {1, 1, 1}, 2));
//		System.out.println(new L531SubArraySumEqualsK().subarraySum(new int[] {10, 2, -2, -20, 10, 10}, 10)); //5
//		System.out.println(new L531SubArraySumEqualsK().subarraySum(new int[] {1}, 0)); //0
		System.out.println(new L531SubArraySumEqualsK().subarraySum(new int[] {-1, -1, 1}, 2)); //5
	}
}
