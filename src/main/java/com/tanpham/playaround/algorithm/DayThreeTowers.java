package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DayThreeTowers {

	static class Tower {
		private int height;
		private int total;
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public Tower(int height, int total) {
			super();
			this.height = height;
			this.total = total;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Tower tower = getTower(arr);
		System.out.print(tower.height + " " + tower.total);
	}
	
	//FIXME: correct the total value, it should represent for all possible built towers
	public static Tower getTower(int[] arr) {
		Arrays.sort(arr);
		int maxHeight = -1;
		int curHeight = 1;
		int total = 0;
		for (int i = arr.length - 1; i >= 1; i--) {
			if (arr[i] == arr[i - 1]) {
				curHeight++;
			} else {
				if (curHeight > maxHeight) {
					maxHeight = curHeight;
					total = arr[i];
				}
			}
		}
		
		if (maxHeight == -1) {
			return new Tower(curHeight, arr[0]);
		}
		return new Tower(maxHeight, total);
	}
	
}
