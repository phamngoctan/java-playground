package com.tanpham.playaround.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	Pair destination;
	int[][] direction = new int[][]{
		{0,-1},
		{1,0},
		{0,1},
		{-1,0}
		};
		
	static class Pair {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void solve(char[][] grid, Pair s) {
		Queue<Pair> q = new LinkedList<>();
		q.add(s);
		grid[s.x][s.y]++;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.x == destination.x && cur.y == destination.y) {
//				return grid[cur.x][cur.y];
			}
			
			for (int i = 0; i < direction.length;i++) {
				int newX = cur.x + direction[i][0];
				int newY = cur.y + direction[i][1];
				if (newX >= 0 
					&& newX <= destination.x
					&& newY >= 0
					&& newY <= destination.y
					&& grid[newX][newY] == 0) {
//					grid[newX][newY] = grid[cur.x][cur.y] + 1;
					q.add(new Pair(newX, newY));
				}
			}
		}
//		return -1;
	}
}
