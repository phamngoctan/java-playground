package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day9BombsNoTheyAreMines {

	private static final int BOMB = -1;
	private static int R;
	private static int C;
	private static int[][] rc = new int[][] {
//		{-1, 0}, 
		{0, 1},
		{1, 0},
//		{0, -1}
	};

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
			int[][] matrix = new int[R][C];
			
			int rowsHasBomb = sc.nextInt();
			for (int i = 0; i < rowsHasBomb; i++) {
				int row = sc.nextInt();
				int numberOfBombs = sc.nextInt();
				for (int j = 0; j < numberOfBombs; j++) {
					matrix[row][sc.nextInt()] = BOMB;
				}
			}
			
			int startingX = sc.nextInt();
			int startingY = sc.nextInt();
			
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
			System.out.println("==================");
			BFS(matrix, startingX, startingY, 0);
			for (int i = 0; i < R; i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
		}
		sc.close();
	}

	private static void BFS(int[][] matrix, int startingX, int startingY, int preValue) {
		if (startingX < 0
				|| startingX >= R
				|| startingY < 0
				|| startingY >= C
				|| matrix[startingX][startingY] == BOMB
				) {
			return;
		}
		if (matrix[startingX][startingY] != 0 && preValue + 1 < matrix[startingX][startingY]) {
			matrix[startingX][startingY] = preValue + 1;
		} else {
			matrix[startingX][startingY] += 1;
		}
		
		for (int i = 0; i < 2; i++) {
			BFS(matrix, startingX + rc[i][0], startingY + rc[i][1], matrix[startingX][startingY]);
		}
	}
	
}
