package com.tanpham.playaround.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day9BombsNoTheyAreMines {

	private static int R;
	private static int C;
	private static int[][] rc = new int[][] {
		{-1, 0}, 
		{0, 1},
		{1, 0},
		{0, -1}
	};
	private static int steps;
	private static Node[][] path;
	
	static class Node {
		public int x;
		public int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
//		for (int i = 0; i < 4; i++) {
//			System.out.println(rc[i][0] + " " + rc[i][1]);
//		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			R = sc.nextInt();
			C = sc.nextInt();
			if (R == 0 && C == 0) {
				break;
			}
			boolean[][] visited = new boolean[R][C];
			path = new Node[R][C];
			steps = 0;
			
			int rowsHasBomb = sc.nextInt();
			for (int i = 0; i < rowsHasBomb; i++) {
				int row = sc.nextInt();
				int numberOfBombs = sc.nextInt();
				for (int j = 0; j < numberOfBombs; j++) {
					int bombColumn = sc.nextInt();
					visited[row][bombColumn] = true;
					path[row][bombColumn] = new Node(-1, -1);
				}
			}
			
			int startingX = sc.nextInt();
			int startingY = sc.nextInt();
			
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			BFS(visited, startingX, startingY, path);
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(path[i]));
//			}
			shortestPath(new Node(startingX, startingY), new Node(endX, endY));
			System.out.println(steps);
		}
		sc.close();
	}

	private static void BFS(boolean[][] visited, int startingX, int startingY, Node[][] path) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startingX, startingY));
		visited[startingX][startingY] = true;
		
		while (!queue.isEmpty() ) {
			Node curNode = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = curNode.x + rc[i][0];
				int newY = curNode.y + rc[i][1];
				if (newX < 0
						|| newX >= R
						|| newY < 0
						|| newY >= C
						|| visited[newX][newY] == true) {
					continue;
				}
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
				path[newX][newY] = new Node(curNode.x, curNode.y);
			}
		}
	}
	
	private static void shortestPath(Node start, Node end) {
		if (start.equals(end) || end.equals(new Node(-1, -1))) {
		} else {
			steps++;
			shortestPath(start, path[end.x][end.y]);
		}
	}

	
}
