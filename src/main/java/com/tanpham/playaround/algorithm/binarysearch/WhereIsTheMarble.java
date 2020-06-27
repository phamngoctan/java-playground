package com.tanpham.playaround.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class WhereIsTheMarble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int caseNum = 1;
		while (N != 0 && Q != 0) {
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.println("CASE# " + caseNum + ":");
			for (int i = 0; i < Q; i++) {
				int u = sc.nextInt();
				int res = binarySearchFirstMatched(arr, 0, arr.length - 1, u);
				if (res == -1) {
					System.out.println(u + " not found");
				} else {
					System.out.println(u + " found at " + (res + 1));
				}
			}
			
			N = sc.nextInt();
			Q = sc.nextInt();
			caseNum++;
		}
		sc.close();
	}
	
	private static int binarySearchFirstMatched(int[] arr, int left, int right, int valueToBeChecked) {
		while (left <= right) {
			int mid = left + (right - left)/2;
			if ((mid == left || valueToBeChecked > arr[mid - 1])
					&& valueToBeChecked == arr[mid]) {
				return mid;
			} 
			 else if (valueToBeChecked > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
