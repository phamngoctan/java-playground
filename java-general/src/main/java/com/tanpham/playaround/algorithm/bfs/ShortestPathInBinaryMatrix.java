package com.tanpham.playaround.algorithm.bfs;
import java.util.Queue;
import java.util.LinkedList;

class ShortestPathInBinaryMatrix {
	Pair destination;
	
	// eight directions sorted in clockwise order
	int[][] direction = new int[][]{
		{-1,-1},
		{0,-1},
		{1,-1},
		{1,0},
		{1,1},
		{0,1},
		{-1,1},
		{-1,0}
		};
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,1,1}, {1,0,0}, {1,0,0}};
		System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
	}
		
    public int shortestPathBinaryMatrix(int[][] grid) {
		destination = new Pair(grid.length - 1, grid[0].length - 1);
		if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
			return -1;
		}
		return BFS(grid, new Pair(0,0), 0);
    }
	
	static class Pair {
		public int x;
		public int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private int BFS(int[][] grid, Pair s, int length) {
		Queue<Pair> q = new LinkedList<>();
		q.add(s);
		grid[s.x][s.y]++;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.x == destination.x && cur.y == destination.y) {
				return grid[cur.x][cur.y];
			}
			
			for (int i = 0; i < direction.length;i++) {
				int newX = cur.x + direction[i][0];
				int newY = cur.y + direction[i][1];
				if (newX >= 0 
					&& newX <= destination.x
					&& newY >= 0
					&& newY <= destination.y
					&& grid[newX][newY] == 0) {
					grid[newX][newY] = grid[cur.x][cur.y] + 1;
					q.add(new Pair(newX, newY));
				}
			}
		}
		return -1;
 	}
}
