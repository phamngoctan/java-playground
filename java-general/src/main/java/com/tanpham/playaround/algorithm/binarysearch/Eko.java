package com.tanpham.playaround.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Source: SPOJ
 * 
 * Time complexity is O(nlogn)
 * Compare with non-sort approach, it kinds of a little improve in time consuming but overall, not so much
 * So I would keep the clean approach :)
 *
 * Test cases:

4 15
8 1 20 9

 *
 * Reference: https://arpitbhayani.me/competitive-programming-solutions/spoj/eko
 *
 */
public class Eko {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		// introduce max variable to avoid sorting
//		int max = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
//			if (arr[i] > max) {
//				max = arr[i];
//			}
		}
		sc.close();
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr[arr.length - 1];
//		int right = max;
		int heightToCutOff = 0;
		while (left <= right) {
			int mid = left + (right - left)/2;
			long curAmountOfCutOffWood = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] - mid > 0) {
					curAmountOfCutOffWood += arr[i] - mid;
				}
			}
			
			if (curAmountOfCutOffWood == k) {
				heightToCutOff = mid;
				break;
			} else if (curAmountOfCutOffWood < k) {
				right = mid - 1;
			} else {
				left = mid + 1;
				// Because we already sort the arr so we don't need the if statement
//				if (mid > heightToCutOff) {
//					heightToCutOff = mid;
//				}
				heightToCutOff = mid;
			}
		}
		System.out.println(heightToCutOff);
	}
	
}
