package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L530Test {

	private L530 l530 = new L530();
	
	/**
	 * Input:
		11110
		11010
		11000
		00000
	 */
	@Test
	public void test_1() {
		char[][] grid = new char[4][5];
		grid[0][0] = '1';
		grid[0][1] = '1';
		grid[0][2] = '1';
		grid[0][3] = '1';

		grid[1][0] = '1';
		grid[1][1] = '1';
		grid[1][3] = '1';
		
		grid[2][0] = '1';
		grid[2][1] = '1';
		
		assertThat(l530.numIslands(grid), Matchers.equalTo(1));
	}
	
	/**
	 * Input:
		11000
		11000
		00100
		00011
	 */
	@Test
	public void test_2() {
		char[][] grid = new char[4][5];
		grid[0][0] = '1';
		grid[0][1] = '1';

		grid[1][0] = '1';
		grid[1][1] = '1';
		
		grid[2][2] = '1';
		
		grid[3][3] = '1';
		grid[3][4] = '1';
		
		assertThat(l530.numIslands(grid), Matchers.equalTo(3));
	}
}
