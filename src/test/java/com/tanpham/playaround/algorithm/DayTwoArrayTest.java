package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.DayTwoArray.Range;

public class DayTwoArrayTest {
	
	@Test
	public void myTestCase01() {
		int[] arr = new int[] {1, 2, 2, 3};
		int totalDiffValue = 3;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		assertThat(position.from, Matchers.equalTo(1));
		assertThat(position.to, Matchers.equalTo(4));
	}

	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 2, 2, 3};
		int totalDiffValue = 2;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		assertThat(position.from, Matchers.equalTo(1));
		assertThat(position.to, Matchers.equalTo(2));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {1, 1, 2, 2, 3, 3, 4, 5};
		int totalDiffValue = 3;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		assertThat(position.from, Matchers.equalTo(2));
		assertThat(position.to, Matchers.equalTo(5));
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {4, 7, 7, 4, 7, 4, 7};
		int totalDiffValue = 4;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		assertThat(position.from, Matchers.equalTo(-1));
		assertThat(position.to, Matchers.equalTo(-1));
	}
	
	@Test
	public void testCase04() {
		int[] arr = new int[] {2, 5, 6, 5, 2, 1, 7, 9, 7, 2, 5, 5, 2, 4, 7, 6, 2, 2, 8, 7, 7, 9, 8, 1, 9, 6, 10, 8, 8, 6, 10, 3, 3, 9, 1, 10, 5, 8, 1, 10, 7, 8, 4, 8, 6, 5, 1, 10, 2, 5};
		int totalDiffValue = 7;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		assertThat(position.from, Matchers.equalTo(43));
		assertThat(position.to, Matchers.equalTo(49));
	}
	
}
