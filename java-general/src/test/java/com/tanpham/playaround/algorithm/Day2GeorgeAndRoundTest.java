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

	@Test
	public void testCase04() {
		int[] arr = new int[] {30, 32, 34, 39, 42, 43, 45, 46, 47, 48, 52, 55, 56, 57, 58, 59, 60, 65, 67, 69};
		int[] existedExercises = new int[] {2, 3, 4, 5, 8, 9, 14, 16, 18, 20, 24, 27, 29, 30, 34, 35, 36, 37, 40, 41, 42, 43, 44, 45, 46};
		int numberOfToBePreparedExercise = Day2GeorgeAndRound.getNumberOfToBePreparedExercise(arr, existedExercises);
		assertThat(numberOfToBePreparedExercise, Matchers.equalTo(12));
	}
}
