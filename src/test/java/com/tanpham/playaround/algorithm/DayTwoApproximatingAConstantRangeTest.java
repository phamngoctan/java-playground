package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayTwoApproximatingAConstantRangeTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 2, 3, 3, 2};
		assertThat(DayTwoApproximatingAConstantRange.getMaxLength(arr), Matchers.equalTo(4));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {5, 4, 5, 5, 6, 7, 8, 8, 8, 7, 6};
		assertThat(DayTwoApproximatingAConstantRange.getMaxLength(arr), Matchers.equalTo(5));
	}
	
}
