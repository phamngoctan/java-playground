package com.tanpham.playaround.leetcode;

public class L530 {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void bfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length  || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return;
		}
		
		grid[i][j] = '0';
		bfs(grid, i + 1, j);
		bfs(grid, i - 1, j);
		bfs(grid, i, j - 1);
		bfs(grid, i, j + 1);
	}
	
}
