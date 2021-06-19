package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayThreeBusinessTripTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 1, 1, 1, 2, 2, 3, 2, 2, 1, 1, 1};
		int minimumMonth = Day3BusinessTrip.countMinimumMonth(5, arr);
		assertThat(minimumMonth, Matchers.equalTo(2));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 0};
		int minimumMonth = Day3BusinessTrip.countMinimumMonth(0, arr);
		assertThat(minimumMonth, Matchers.equalTo(0));
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {1, 1, 4, 1, 1, 5, 1, 1, 4, 1, 1, 1};
		int minimumMonth = Day3BusinessTrip.countMinimumMonth(11, arr);
		assertThat(minimumMonth, Matchers.equalTo(3));
	}
	
	@Test
	public void testCase04() {
		int[] arr = new int[] {3, 3, 8, 12, 3, 7, 4, 3, 2, 14, 3, 9};
		int minimumMonth = Day3BusinessTrip.countMinimumMonth(83, arr);
		assertThat(minimumMonth, Matchers.equalTo(-1));
	}
	
}
