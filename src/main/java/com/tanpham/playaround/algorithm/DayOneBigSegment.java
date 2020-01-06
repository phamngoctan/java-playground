package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DayOneBigSegment {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numberOfSegment = sc.nextInt();
		sc.nextLine();
		String[] arrStr = new String[numberOfSegment];
		for (int i = 0; i < numberOfSegment; i++) {
			arrStr[i] = sc.nextLine();
		}
		sc.close();
		Arrays.stream(arrStr).forEach(str -> System.out.println(str));
	}
	
	public static int findCorrectNumberOfBigSegment(int[][] arr) {
		// implement brute force for this, try to improve it later
		int[] segmentHasMin = new int[6];
		int[] segmentHasMax = new int[6];
		
		int min = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
//				if (arr[i][j] <= min)
			}
		}
		return 0;
	}

}
