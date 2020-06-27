package com.tanpham.playaround.algorithm.binarysearch;

/**
 * NOTES:
 * - overflow when calculating mid
 * - binary search with first matched value (https://thebittheories.com/the-curious-case-of-binary-search-the-famous-bug-that-remained-undetected-for-20-years-973e89fc212)
 * - binary search with last matched value
 * - lower bound
 * - upper bound
 */
public class Setup {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 2, 5, 9, 10, 100, 1000, 1400
		};
		int left = 0;
		int right = arr.length;
		int res = binarySearch(arr, left, right, 2);
		if (res == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("Found");
		}
	}

	private static int binarySearch(int[] arr, int left, int right, int valueToBeChecked) {
		int mid;
		while (left <= right) {
			//mid = (left + right) / 2; // NONO: 20 years to be fixed, overflow possibly
			mid = left + (right - left) / 2;
			if (valueToBeChecked < arr[mid]) {
				right = mid;
			} else if (valueToBeChecked == arr[mid]) {
				return mid;
			} else {
				left = mid;
			}
		}
		return -1;
	}
	
}
