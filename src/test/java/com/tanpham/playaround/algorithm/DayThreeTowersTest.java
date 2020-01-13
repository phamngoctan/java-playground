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
	public void myTestCase02() {
		int[] arr = new int[] {6, 7, 7, 8, 8};
		Tower tower = DayThreeTowers.getTower(arr);
		assertThat(tower.getHeight(), Matchers.equalTo(2));
//		assertThat(tower.getTotal(), Matchers.equalTo(4));
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
	
	@Test
	public void testCase05() {
		int[] arr = new int[] {47, 30, 94, 41, 45, 20, 96, 51, 110, 129, 24, 116, 9, 47, 32, 82, 105, 114, 116, 75, 154, 151, 70, 42, 162};
		Tower tower = DayThreeTowers.getTower(arr);
		assertThat(tower.getHeight(), Matchers.equalTo(2));
		assertThat(tower.getTotal(), Matchers.equalTo(23));
	}
	
}
