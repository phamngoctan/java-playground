package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayTwoWrathTest {
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {1, 1, 3, 0, 0, 0, 2, 1, 0, 3};
		assertThat(DayTwoWrath.countAlivePeople(arr), Matchers.equalTo(3));
	}

}
