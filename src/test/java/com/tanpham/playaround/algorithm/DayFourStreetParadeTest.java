package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayFourStreetParadeTest {

	@Test
	public void myTestCase01() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {2, 1});
		assertThat(canReordered, Matchers.equalTo(true));
	}
	
	@Test
	public void myTestCase02() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {3, 4, 1, 5, 2, 6});
		assertThat(canReordered, Matchers.equalTo(false));
	}
	
	@Test
	public void myTestCase03() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		assertThat(canReordered, Matchers.equalTo(true));
	}
	
	@Test
	public void myTestCase04() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {2, 1, 3, 4});
		assertThat(canReordered, Matchers.equalTo(true));
	}
	
	@Test
	public void myTestCase05() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {3, 2, 1, 4, 5, 6});
		assertThat(canReordered, Matchers.equalTo(true));
	}
	
	@Test
	public void testCase01() {
		boolean canReordered = DayFourStreetParade.canReordered(new Integer[] {5, 1, 2, 4, 3});
		assertThat(canReordered, Matchers.equalTo(true));
	}
	
}
