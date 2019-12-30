package com.tanpham.playaround.sorting;

import java.util.Random;

/*
 * No generic approach, just want to keep it simple
 */
public class QuickSort {

	public void proceed(int[] arr) {
		shuffleArray(arr);
		
		quickSort(arr, 0, arr.length - 1);
	}
	
	private void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int mid = partition(arr, low, high);
		quickSort(arr, low, mid - 1);
		quickSort(arr, mid + 1, high);
	}

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
	
	public static void exchange(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// Implementing Fisher–Yates shuffle in modern style
	public static void shuffleArray(int[] arr) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}
	
}
