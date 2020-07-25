package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day2SerejaAndDima {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrN = new int[n];
		for (int i = 0; i < n; i++) {
			arrN[i] = sc.nextInt();
		}
		int i = 0;
		int j = n - 1;
		int[] res = new int[2];
		int player = 0;
		while (i <= j) {
			if (arrN[i] >= arrN[j]) {
				res[player] += arrN[i];
				i++;
			} else {
				res[player] += arrN[j];
				j--;
			}
			player = 1 - player;
		}
		System.out.println(res[0] + " " + res[1]);
	}
	
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
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int length = sc.nextInt();
//		int[] arr = new int[length];
//		for (int i = 0; i < length; i++) {
//			arr[i] = sc.nextInt();
//		}
//		sc.close();
//		Pair pair = getTotal(arr);
//		System.out.println(pair.getFirst() + " " + pair.getSecond());
//	}
	
//	public static Pair getTotal(int[] arr) {
//		int serejaCards = 0;
//		int dimaCards = 0;
//		
//		int i = 0;
//		int j = arr.length - 1;
//		boolean switcher = true;
//		while (i <= j) {
//			int higherValue = arr[j];
//			if (higherValue > arr[i]) {
//				j--;
//			} else {
//				higherValue = arr[i];
//				i++;
//			}
//			
//			if (switcher) {
//				serejaCards += higherValue;
//				switcher = false;
//			} else {
//				dimaCards += higherValue;
//				switcher = true;
//			}
//		}
//		return new Pair(serejaCards, dimaCards);
//	}
	
	public static Pair getTotal(int[] arr) {
		int[] cardNum = new int[2];
		
		int i = 0;
		int j = arr.length - 1;
		int player = 0;
		while (i <= j) {
			if (arr[j] > arr[i]) {
				cardNum[player] += arr[j];
				j--;
			} else {
				cardNum[player] += arr[i];
				i++;
			}
			player = 1 - player;
		}
		return new Pair(cardNum[0], cardNum[1]);
	}
	
}
