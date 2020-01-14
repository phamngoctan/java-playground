package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day2GeorgeAndRoundTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 2, 3};
		int[] existedExercises = new int[] {1, 2, 2, 3, 3};
		int numberOfToBePreparedExercise = Day2GeorgeAndRound.getNumberOfToBePreparedExercise(arr, existedExercises);
		assertThat(numberOfToBePreparedExercise, Matchers.equalTo(0));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {1, 2, 3};
		int[] existedExercises = new int[] {1, 1, 1, 1, 1};
		int numberOfToBePreparedExercise = Day2GeorgeAndRound.getNumberOfToBePreparedExercise(arr, existedExercises);
		assertThat(numberOfToBePreparedExercise, Matchers.equalTo(2));
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {2, 3, 4};
		int[] existedExercises = new int[] {1};
		int numberOfToBePreparedExercise = Day2GeorgeAndRound.getNumberOfToBePreparedExercise(arr, existedExercises);
		assertThat(numberOfToBePreparedExercise, Matchers.equalTo(3));
	}
}
