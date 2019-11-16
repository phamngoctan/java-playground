package com.tanpham.playaround.searching;

public class DataStructureSearching {

	public static boolean binarySearchRecursive(int[] arr, int toBeSearched) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int min = 0;
		int max = arr.length;
		return binarySearchApplyRecursive(arr, toBeSearched, min, max);
	}

	private static boolean binarySearchApplyRecursive(int[] arr, int toBeSearched, int min, int max) {
		if (min > max) {
			return false;
		}
		
		int middlePoint = (max - min) / 2;
		if (toBeSearched == arr[middlePoint + min]) {
			return true;
		} else if (toBeSearched < arr[middlePoint + min]) {
			return binarySearchApplyRecursive(arr, toBeSearched, min, middlePoint);
		} else {
			return binarySearchApplyRecursive(arr, toBeSearched, middlePoint + 1, max);
		}
	}

}
