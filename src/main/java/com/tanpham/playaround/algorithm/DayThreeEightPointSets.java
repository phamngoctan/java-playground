package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DayThreeEightPointSets {

	static class Point {
		private int x;
		private int y;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point[] arr = new Point[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		
		System.out.println(checkIfRespectablePointSets(arr) ? "respectable" : "ugly");
	}
	
	
	/*
	 * idea:
	 * sort points(x, y)
	 * sort follow x
	 *  for each x, we add it to the unique u_x
	 * sort follow y
	 *  for each y, we add it to the unique u_y
	 * check size of u_x == 3 or not
	 * check size of u_y == 3 or not
	 * 
	 * for 0 -> 2
	 *   for 0 -> 2
	 *     check ...
	 * 
	 * 8 log 8
	 * 
	 */
	public static boolean checkIfRespectablePointSets(Point[] arr) {
		Arrays.sort(arr, (o1, o2) -> {
			if (o1.x > o2.x) {
				return 1;
			} else if (o1.x < o2.x) {
				return -1;
			} else {
				if (o1.y > o2.y) {
					return 1;
				} else if (o1.y < o2.y ) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		if (checkVerticalX(arr)
				&& checkHorizontalY(arr)) {
			return true;
		}
		
		return false;
	}

	private static boolean checkVerticalX(Point[] arr) {
		return arr[0].x == arr[1].x && arr[1].x == arr[2].x
				&& arr[3].x == arr[4].x
				&& arr[5].x == arr[6].x && arr[6].x == arr[7].x;
	}
	
	private static boolean checkHorizontalY(Point[] arr) {
		return arr[0].y == arr[3].y && arr[3].y == arr[5].y
				&& arr[1].y == arr[6].y
				&& arr[2].y == arr[4].y && arr[4].y == arr[7].y;
	}
	
}
