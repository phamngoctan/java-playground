package com.tanpham.playaround.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/*
 * For this exercise, we can even use a hash to store the value and number of its appearance.
 * Then, we can instantly count the number of pair with have, complexity is O(n)
 * 
 * The current implementation time complexity is O(nlogn)
 */
public class Pizzamania {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			handleATestCase(sc);
		}
		sc.close();
	}

	private static void handleATestCase(Scanner sc) {
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (binarySearch(arr, 0, n - 1, i, sum - arr[i]) != -1) {
				count++;
			}
		}
		System.out.println(count/2);
	}

	private static int binarySearch(int[] arr, int l, int r, int i, int x) {
		while (l <= r) {
			int mid = l + (r - l)/2;
			if (arr[mid] == x && mid != i) {
				return mid;
			} else if (x < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
	
}
