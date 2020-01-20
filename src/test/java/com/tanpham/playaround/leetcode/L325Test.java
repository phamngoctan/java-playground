package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L325Test {

	@Test
	public void testCase01() {
		int[] nums = new int[] {1, -1, 5, -2, 3};
		assertThat(L325.maxSubArrayLen(nums, 3), Matchers.equalTo(4));
	}
	
	@Test
	public void testCase02() {
		int[] nums = new int[] {-2, -1, 2, 1};
		assertThat(L325.maxSubArrayLen(nums, 1), Matchers.equalTo(2));
	}
	
}
