package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.Day2AliceBobAndChocolate.Pair;

public class Day2AliceBobAndChocolateTest {

	@Test
	public void myTestCase01() {
		int[] arr = new int[] {5, 4, 8, 2, 7};
		Pair result = Day2AliceBobAndChocolate.getAmountOfChocolateBars(arr);
		assertThat(result.getFirst(), 
						Matchers.equalTo(3));
		assertThat(result.getSecond(), 
				Matchers.equalTo(2));
	}
	
	@Test
	public void testCase01() {
		int[] arr = new int[] {2, 9, 8, 2, 7};
		Pair result = Day2AliceBobAndChocolate.getAmountOfChocolateBars(arr);
		assertThat(result.getFirst(), 
						Matchers.equalTo(2));
		assertThat(result.getSecond(), 
				Matchers.equalTo(3));
	}
	
}
