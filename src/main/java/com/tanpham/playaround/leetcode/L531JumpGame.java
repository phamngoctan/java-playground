package com.tanpham.playaround.leetcode;

public class L531JumpGame {
	
}

/**
 * Timeout, not good because it takes O(n^2)
 */
//class Solution {    
//    public boolean canJump(int[] nums) {
//        return reachTarget(nums, 0, nums[0]);
//    }
//    
//    private boolean reachTarget(int[] nums, int start, int numJumpStep) {
//        if (start >= nums.length - 1) {
//            return true;
//        }
//        
//        for (int j = 1; j <= numJumpStep; j++) {
//            if (reachTarget(nums, start + j, nums[start + j])) {
//                return true;
//            }
//        }
//        return false;
//    }
//}

class Solution {
	public boolean canJump(int[] nums) {
		int last = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > last) {
				return false;
			}
			last = Math.max(last, nums[i] + i);
		}
		return last == nums.length;
	}
}


