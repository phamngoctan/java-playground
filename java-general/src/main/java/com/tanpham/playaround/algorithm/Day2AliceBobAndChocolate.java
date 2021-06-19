package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day2AliceBobAndChocolate {

	static class Pair {
		private int first;
		private int second;
		public int getFirst() {
			return first;
		}
		public void setFirst(int first) {
			this.first = first;
		}
		public int getSecond() {
			return second;
		}
		public void setSecond(int second) {
			this.second = second;
		}
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Pair amountOfChocolateBars = getAmountOfChocolateBars(arr);
		System.out.println(amountOfChocolateBars.getFirst() + " " + amountOfChocolateBars.getSecond());
	}
	
	public static Pair getAmountOfChocolateBars(int[] arr) {
		if (arr.length == 1) {
			return new Pair(1, 0);
		}
		
		int totalAlice = arr[0];
		int totalBob = arr[arr.length - 1];
		
		int i = 0;
		int j = arr.length - 1;
		while (i < j - 1) {
			if (totalAlice <= totalBob) {
				i++;
				totalAlice += arr[i];
			} else {
				j--;
				totalBob += arr[j];
			}
		}
//		System.out.println(totalAlice);
//		System.out.println(totalBob);
		int aliceBars = i + 1;
		return new Pair(aliceBars, arr.length - aliceBars);
	}
	
}
