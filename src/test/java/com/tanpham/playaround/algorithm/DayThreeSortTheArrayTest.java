package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.DayThreeSortTheArray.Range;

public class DayThreeSortTheArrayTest {

	@Test
	public void myTestCase01() {
		int[] arr = new int[] {1, 3, 4, 5, 2, 6};
		assertThat(DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr), Matchers.nullValue());
	}
	
	@Test
	public void myTestCase02() {
		int[] arr = new int[] {69, 37, 27, 4, 2};
		assertThat(DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr), Matchers.nullValue());
	}
	
	@Test
	public void testCast01() {
		int[] arr = new int[] {3, 2, 1};
		Range range = DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr);
		assertThat(range, Matchers.notNullValue());
		assertThat(range.getFrom(), Matchers.equalTo(1));
		assertThat(range.getTo(), Matchers.equalTo(3));
	}
	
	@Test
	public void testCast02() {
		int[] arr = new int[] {2, 1, 3, 4};
		Range range = DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr);
		assertThat(range, Matchers.notNullValue());
		assertThat(range.getFrom(), Matchers.equalTo(1));
		assertThat(range.getTo(), Matchers.equalTo(2));
	}
	
	@Test
	public void testCast03() {
		int[] arr = new int[] {3, 1, 2, 4};
		assertThat(DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr), Matchers.nullValue());
	}
	
	@Test
	public void testCast04() {
		int[] arr = new int[] {1, 2};
		Range range = DayThreeSortTheArray.getPositionsIfExistThatKindOfArray(arr);
		assertThat(range, Matchers.notNullValue());
		assertThat(range.getFrom(), Matchers.equalTo(1));
		assertThat(range.getTo(), Matchers.equalTo(1));
	}
	
}
