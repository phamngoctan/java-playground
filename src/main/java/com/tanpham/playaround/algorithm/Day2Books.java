package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day2Books {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int freeMinutes = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(getNumberOfCanBeReadBooks(arr, freeMinutes));
	}
	
	public static int getNumberOfCanBeReadBooks(int[] arr, int freeMinutes) {
		int maxBookCanRead = 0;
		int numberBooksRead = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			while (freeMinutes < arr[i]) {
				freeMinutes += arr[j];
				numberBooksRead--;
				j++;
			}
			freeMinutes -= arr[i];
			numberBooksRead++;
			maxBookCanRead = Math.max(maxBookCanRead, numberBooksRead);
		}
		return maxBookCanRead;
	}
	
}
