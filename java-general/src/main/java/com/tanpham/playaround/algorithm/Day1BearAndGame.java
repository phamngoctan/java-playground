package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day1BearAndGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrLength = sc.nextInt();
		sc.nextLine();
		String arrStr = sc.nextLine();
		sc.close();
		int[] arr = proceedInputStringToIntArray(arrLength, arrStr);
		System.out.println(calculateBearWatchingTime(arr));
	}
	
	private static int[] proceedInputStringToIntArray(int arrLength, String inputStr) {
		int[] arr = new int[arrLength];
		String[] arrString = inputStr.split(" ");
		for (int i = 0; i < arrLength; i++) {
			arr[i] = new Integer(arrString[i]);
		}
		return arr;
	}
	
	public static int calculateBearWatchingTime(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 90;
		}
		
		int positionHasBoringTimeMoreThan15Minutes = findPositionHasBoringTimeMoreThan15Minutes(arr);
		if (positionHasBoringTimeMoreThan15Minutes == -1) {
			return 90;
		} else if (positionHasBoringTimeMoreThan15Minutes == -2) {
			return 15;
		}
		return arr[positionHasBoringTimeMoreThan15Minutes] + 15;
	}

	public static int findPositionHasBoringTimeMoreThan15Minutes(int[] arr) {
		if (arr[0] > 15) {
			return -2;
		}
		
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] - arr[i - 1]) > 15) {
				return i - 1;
			}
		}
		
		if (arr[arr.length - 1] < 75) {
			return arr.length - 1;
		}
		return -1;
	}
	
}
