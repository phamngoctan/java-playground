package com.tanpham.playaround.sorting;

/**
 * For the sake of implementing sorting idea, it does not support generic approach
 *
 */
public class InsertionSort {

	public void proceed(int[] arr) {
		if (arr == null) {
			return;
		}
		
		int i = 0;
		while (i <= arr.length - 1) {
			int j = i;
			while (j >= 1 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
			i++;
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
