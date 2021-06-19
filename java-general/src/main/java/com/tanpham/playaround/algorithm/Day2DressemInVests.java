package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2DressemInVests {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] arrN = new int[n];
		for (int i = 0; i < n; i++) {
			arrN[i] = sc.nextInt();
		}
		int[] arrM = new int[m];
		for (int i = 0; i < m; i++) {
			arrM[i] = sc.nextInt();
		}
		
		List<String> res = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < n && j < m;) {
			if (arrN[i] - x <= arrM[j] && arrN[i] + y >= arrM[j]) {
				res.add((i + 1) + " " + (j + 1));
				j++;
				i++;
			} else if (arrN[i] + y < arrM[j]) {
				i++;
			} else if (arrN[i] - x > arrM[j]) {
				j++;
			}
		}
		System.out.println(res.size());
		for (String i : res) {
			System.out.println(i);
		}
	}
	
	static class Pair {
		private int solderNumber;
		private int vestNumber;
		public int getSolderNumber() {
			return solderNumber;
		}
		public void setSolderNumber(int solderNumber) {
			this.solderNumber = solderNumber;
		}
		public int getVestNumber() {
			return vestNumber;
		}
		public void setVestNumber(int vestNumber) {
			this.vestNumber = vestNumber;
		}
		public Pair(int solderNumber, int vestNumber) {
			super();
			this.solderNumber = solderNumber;
			this.vestNumber = vestNumber;
		}
	}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int soldierLength = sc.nextInt();
//		int vestLength = sc.nextInt();
//		int lowerBound = sc.nextInt();
//		int higherBound = sc.nextInt();
//		
//		int[] soldierArr = new int[soldierLength];
//		for (int i = 0; i < soldierLength; i++) {
//			soldierArr[i] = sc.nextInt();
//		}
//		
//		int[] vestArr = new int[vestLength];
//		for (int i = 0; i < vestLength; i++) {
//			vestArr[i] = sc.nextInt();
//		}
//		sc.close();
//		
//		List<Pair> result = check(soldierArr, vestArr, lowerBound, higherBound);
//		System.out.println(result.size());
//		for (Pair pair : result) {
//			System.out.println(pair.getSolderNumber() + " " + pair.getVestNumber());
//		}
//	}
	
	/**
	 * If you draw it out, it is easier to visualize the code. Otherwise you may get lost
	 */
	public static List<Pair> check(int[] soldierArr, int[] vestArr, int lowerBound, int higherBound) {
		List<Pair> result = new ArrayList<>();
//		int j = 0;
		// Time exceeds approach
//		for (int i = 0; i < soldierArr.length; i++) {
//			while (j < vestArr.length && !foundVest) {
//				if ((soldierArr[i] - lowerBound) <= vestArr[j]
//						&& (soldierArr[i] + higherBound) >= vestArr[j]) {
//					foundVest = true;
//					preJ = j;
//				} else {
//					j++;
//				}
//			}
//			if (foundVest) {
//				result.add(new Pair(i + 1, j + 1));
//				foundVest = false;
//			}
//			j = preJ + 1;
//		}
		
		int i = 0, j = 0;
		while (i < soldierArr.length && j < vestArr.length) {
			if ((soldierArr[i] - lowerBound) <= vestArr[j] 
					&& (soldierArr[i] + higherBound) >= vestArr[j]) {
				result.add(new Pair(i + 1, j + 1));
				i++;
				j++;
			} else if (soldierArr[i] - lowerBound > vestArr[j]) {
				j++;
			} else if (soldierArr[i] + higherBound < vestArr[j]) {
				i++;
			}
		}
		return result;
	}

}
