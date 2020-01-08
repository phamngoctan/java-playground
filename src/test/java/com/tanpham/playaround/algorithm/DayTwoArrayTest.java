package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.DayTwoArray.Range;

public class DayTwoArrayTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 1, 2, 2, 3, 3, 4, 5};
		int totalDiffValue = 3;
		Range position = DayTwoArray.getPosition(arr, totalDiffValue);
		System.out.println(position);
		assertThat(position.from, Matchers.equalTo(2));
		assertThat(position.to, Matchers.equalTo(5));
	}
	
}
