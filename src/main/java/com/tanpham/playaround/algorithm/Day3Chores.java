package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day3Chores {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		int numberChoresOfPetya = sc.nextInt();
		int numberChoresOfVasya = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(getNumberOfTolerantComplexityWays(arr, numberChoresOfPetya, numberChoresOfVasya));
	}
	
	/*
	 * Quite easy if you understand the topic =))
	 * 
	 */
	public static int getNumberOfTolerantComplexityWays(int[] arr, int numberChoresOfPetya, int numberChoresOfVasya) {
		Arrays.sort(arr);
		int end = arr[numberChoresOfVasya - 1];
		int laterStart = arr[numberChoresOfVasya];
		return laterStart - end;
	}
	
}
