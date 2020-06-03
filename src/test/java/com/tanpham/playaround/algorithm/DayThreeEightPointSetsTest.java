package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.Day3EightPointSets.Point;

public class DayThreeEightPointSetsTest {

	@Test
	public void testCase01() {
		Point[] arr = new Day3EightPointSets.Point[] {
				new Day3EightPointSets.Point(0, 0),
				new Day3EightPointSets.Point(2, 0),
				new Day3EightPointSets.Point(0, 1),
				new Day3EightPointSets.Point(0, 2),
				new Day3EightPointSets.Point(1, 0),
				new Day3EightPointSets.Point(1, 2),
				new Day3EightPointSets.Point(2, 1),
				new Day3EightPointSets.Point(2, 2),
			};
		boolean checkIfRespectablePointSets = Day3EightPointSets.checkIfRespectablePointSets(arr);
		assertThat(checkIfRespectablePointSets, Matchers.equalTo(true));
	}
	
	@Test
	public void testCase02() {
		Point[] arr = new Day3EightPointSets.Point[] {
				new Day3EightPointSets.Point(0, 0),
				new Day3EightPointSets.Point(1, 0),
				new Day3EightPointSets.Point(2, 0),
				new Day3EightPointSets.Point(3, 0),
				new Day3EightPointSets.Point(4, 0),
				new Day3EightPointSets.Point(5, 0),
				new Day3EightPointSets.Point(6, 0),
				new Day3EightPointSets.Point(7, 0),
			};
		boolean checkIfRespectablePointSets = Day3EightPointSets.checkIfRespectablePointSets(arr);
		assertThat(checkIfRespectablePointSets, Matchers.equalTo(false));
	}

	@Test
	public void testCase03() {
		Point[] arr = new Day3EightPointSets.Point[] {
				new Day3EightPointSets.Point(1, 1),
				new Day3EightPointSets.Point(1, 2),
				new Day3EightPointSets.Point(1, 3),
				new Day3EightPointSets.Point(2, 1),
				new Day3EightPointSets.Point(2, 2),
				new Day3EightPointSets.Point(2, 3),
				new Day3EightPointSets.Point(3, 1),
				new Day3EightPointSets.Point(3, 2),
		};
		boolean checkIfRespectablePointSets = Day3EightPointSets.checkIfRespectablePointSets(arr);
		assertThat(checkIfRespectablePointSets, Matchers.equalTo(false));
	}
	
}
