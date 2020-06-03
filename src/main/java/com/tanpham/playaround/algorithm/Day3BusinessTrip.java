package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day3BusinessTrip {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minimumTreeTall = sc.nextInt();
		
		int[] arr = new int[12];
		for (int i = 0; i < 12; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(countMinimumMonth(minimumTreeTall, arr));
	}
	
	public static int countMinimumMonth(int minimumTreeTall, int[] arr) {
		Arrays.sort(arr);
		int countMonths = 0;
		int countCentimeters = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (countCentimeters < minimumTreeTall) {
				countMonths++;
				countCentimeters += arr[i];
			}
			if (countCentimeters >= minimumTreeTall) {
				break;
			}
		}
		if (countCentimeters < minimumTreeTall) {
			return -1;
		}
		return countMonths;
	}
	
}
