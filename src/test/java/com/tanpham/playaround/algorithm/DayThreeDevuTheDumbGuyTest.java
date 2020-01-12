package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayThreeDevuTheDumbGuyTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {4, 1};
		assertThat(DayThreeDevuTheDumbGuy.getMinStudyTime(arr, 3), Matchers.equalTo(new BigDecimal(11)));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {5, 1, 2, 1};
		assertThat(DayThreeDevuTheDumbGuy.getMinStudyTime(arr, 2), Matchers.equalTo(new BigDecimal(10)));
	}
	
}
