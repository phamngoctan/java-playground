package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneArraysTest {

	@Test
	public void testCase1() {
		int[] arr1 = new int[] {1, 3, 5};
		int[] arr2 = new int[] {2, 6, 9, 11};
		int num1 = 3;
		int num2 = 4;
		assertThat(DayOneArrays.check(arr1, arr2, num1, num2), Matchers.equalTo(false));
	}

	@Test
	public void testCase2() {
		int[] arr1 = new int[] {1, 2, 3};
		int[] arr2 = new int[] {3, 4, 5};
		int num1 = 3;
		int num2 = 3;
		assertThat(DayOneArrays.check(arr1, arr2, num1, num2), Matchers.equalTo(false));
	}
	
	@Test
	public void testCase3() {
		int[] arr1 = new int[] {1, 2, 3};
		int[] arr2 = new int[] {3, 4, 5};
		int num1 = 2;
		int num2 = 3;
		assertThat(DayOneArrays.check(arr1, arr2, num1, num2), Matchers.equalTo(true));
	}
	
	@Test
	public void testCase4() {
		int[] arr1 = new int[] {1, 1, 1, 1, 1};
		int[] arr2 = new int[] {2, 2};
		int num1 = 3;
		int num2 = 1;
		assertThat(DayOneArrays.check(arr1, arr2, num1, num2), Matchers.equalTo(true));
	}
	
	@Test
	public void testCase5() {
		int[] arr1 = new int[] {3, 4, 5, 6};
		int[] arr2 = new int[] {6, 7, 8, 9};
		int num1 = 3;
		int num2 = 2;
		assertThat(DayOneArrays.check(arr1, arr2, num1, num2), Matchers.equalTo(true));
	}
	
//	@Test
//	public void findMinLarger() {
//		assertThat(DayOneArrays.findMinLargerThanValue(new int[] {2, 6, 9, 15, 20}, 7), Matchers.equalTo(2));
//	}
}
