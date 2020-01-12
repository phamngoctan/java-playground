package com.tanpham.playaround.algorithm;

import org.junit.Test;

public class DayThreeGukiZAndContestTest {

	@Test
	public void myTestCase01() {
		int[] arr = new int[] {5, 4, 5, 3};
		DayThreeGukiZAndContest.getLevels(arr);
	}
	
	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 3, 3};
		DayThreeGukiZAndContest.getLevels(arr);
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {1};
		DayThreeGukiZAndContest.getLevels(arr);
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {3, 5, 3, 4, 5};
		DayThreeGukiZAndContest.getLevels(arr);
	}
	
}
