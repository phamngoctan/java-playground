package com.tanpham.playaround.leetcode;

public class L530MinPathSum {

	/**
	 * Input:
		[
		  [1,3,1],
		  [1,5,1],
		  [4,2,1]
		]
		Output: 7
		Explanation: Because the path 1 3 1 1 1 minimizes the sum.
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		return bfs(grid, 0, 0);
	}

	private int bfs(int[][] grid, int i, int j) {
		if (i >= grid.length || j >= grid[i].length) {
			return 0;
		}
		int bottom = bfs(grid, i + 1, j);
		int right = bfs(grid, i, j + 1);
		return grid[i][j] + Math.min(bottom, right);
	}

}
