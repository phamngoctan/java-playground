package com.tanpham.playaround.sorting;

/*
 * No generic approach, just want to keep it simple
 */
public class QuickSort {

	/**
	 * The next partition point will be = high if arr[low] = biggest value<br/>
	 * The next partition point will be = low if arr[low] = smallest value
	 * 
	 */
	public int partition(int arr[], int low, int high) {
		int i = low;
		int j = high + 1;
		while (true) {
			while (arr[++i] <= arr[low]) {
				if (i >= high) {
					break;
				}
			}
			
			while (arr[low] <= arr[--j]) {
				if (j <= low) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			exchange(arr, i, j);
		}
		
		exchange(arr, low, j);
		return j;
	}
	
	private void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
