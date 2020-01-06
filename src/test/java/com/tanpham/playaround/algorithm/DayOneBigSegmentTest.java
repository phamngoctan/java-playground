package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneBigSegmentTest {
	
	@Test
	public void testCase01() {
		int[][] arr = new int[][] {new int[] {3, 3}, new int[] {4, 4, 4}, new int[] {5, 5}};
		int numberOfBigSegment = DayOneBigSegment.findCorrectNumberOfBigSegment(arr);
		assertThat(numberOfBigSegment, Matchers.equalTo(-1));
	}
	
}
