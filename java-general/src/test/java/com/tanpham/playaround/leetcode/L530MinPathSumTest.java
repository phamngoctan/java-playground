package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L530MinPathSumTest {
	
	private L530MinPathSum l530MinPathSum = new L530MinPathSum();
	
	@Test
	public void test_1() {
		int[][] grid = new int[3][3];
		grid[0][0] = 1;
		grid[0][1] = 3;
		grid[0][2] = 1;
		
		grid[1][0] = 1;
		grid[1][1] = 5;
		grid[1][2] = 1;

		grid[2][0] = 4;
		grid[2][1] = 2;
		grid[2][2] = 1;
		
		assertThat(l530MinPathSum.minPathSum(grid), Matchers.equalTo(7));
	}
	
	@Test
	public void test_2() {
		int[][] grid = new int[1][1];
		grid[0][0] = 1;
		assertThat(l530MinPathSum.minPathSum(grid), Matchers.equalTo(1));
	}
}
