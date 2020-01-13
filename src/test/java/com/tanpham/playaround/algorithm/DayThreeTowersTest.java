package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.DayThreeTowers.Tower;

public class DayThreeTowersTest {

	@Test
	public void myTestCase01() {
		int[] arr = new int[] {7, 7, 7};
		Tower tower = DayThreeTowers.getTower(arr);
		assertThat(tower.getHeight(), Matchers.equalTo(3));
		assertThat(tower.getTotal(), Matchers.equalTo(1));
	}
	
	@Test
	public void testCase01() {
		int[] arr = new int[] {1, 2, 3};
		Tower tower = DayThreeTowers.getTower(arr);
		assertThat(tower.getHeight(), Matchers.equalTo(1));
		assertThat(tower.getTotal(), Matchers.equalTo(3));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {6, 5, 6, 7};
		Tower tower = DayThreeTowers.getTower(arr);
		assertThat(tower.getHeight(), Matchers.equalTo(2));
		assertThat(tower.getTotal(), Matchers.equalTo(3));
	}
	
}
