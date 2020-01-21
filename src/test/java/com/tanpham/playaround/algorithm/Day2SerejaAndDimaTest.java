package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.Day2SerejaAndDima.Pair;

public class Day2SerejaAndDimaTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {4, 1, 2, 10};
		Pair total = Day2SerejaAndDima.getTotal(arr);
		assertThat(total.getFirst(), Matchers.equalTo(12));
		assertThat(total.getSecond(), Matchers.equalTo(5));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
		Pair total = Day2SerejaAndDima.getTotal(arr);
		assertThat(total.getFirst(), Matchers.equalTo(16));
		assertThat(total.getSecond(), Matchers.equalTo(12));
	}
	
}
