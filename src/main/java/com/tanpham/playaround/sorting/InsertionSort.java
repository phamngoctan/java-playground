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
			
			// FYI: this while, check & swap can be replaced with binary search and swap, because the first part is already sorted.
			// So we can perform binary search on the part.
			// And it is resulted in a better result.
			// n log n. But even we can find the correct position, we also have to shift the array. So the swap still be needed.
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
