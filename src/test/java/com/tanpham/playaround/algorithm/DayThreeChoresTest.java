package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayThreeChoresTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {6, 2, 3, 100, 1};
		assertThat(DayThreeChores.getNumberOfTolerantComplexityWays(arr, 2, 3), Matchers.equalTo(3));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {1, 1, 9, 1, 1, 1, 1};
		assertThat(DayThreeChores.getNumberOfTolerantComplexityWays(arr, 3, 4), Matchers.equalTo(0));
	}
	
}
