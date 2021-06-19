package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day2WrathTest {
	
	@Test
	public void myTestCase01() {
		int[] arr = new int[] {3, 5, 2};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(1));
	}
	
	@Test
	public void myTestCase02() {
		int[] arr = new int[] {1, 3, 5, 2};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(1));
	}
	
	@Test
	public void myTestCase03() {
		int[] arr = new int[] {1, 1, 11, 10};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(1));
	}
	
	@Test
	public void testCase01() {
		int[] arr = new int[] {0, 1, 0, 10};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(1));
	}

	@Test
	public void testCase02() {
		int[] arr = new int[] {0, 0};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(2));
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {1, 1, 3, 0, 0, 0, 2, 1, 0, 3};
		assertThat(Day2Wrath.countAlivePeople(arr), Matchers.equalTo(3));
	}

}
