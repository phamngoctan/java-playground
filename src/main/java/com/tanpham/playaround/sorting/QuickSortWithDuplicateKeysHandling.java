package com.tanpham.playaround.sorting;

/*
 * For the sake of the idea implementation, this class will not support generic type
 */
public class QuickSortWithDuplicateKeysHandling {

	public void proceed(int[] arr) {
		QuickSort.shuffleArray(arr);
		quickSort(arr, 0, arr.length);
	}

	private void quickSort(int[] arr, int low, int high) {
		int partitionPoint = partition(arr, low, high);
		quickSort(arr, 0, partitionPoint - 1);
		quickSort(arr, partitionPoint + 1, high);
	}

	//TODO: implement it
	private int partition(int[] arr, int low, int high) {
		return 0;
	}
	
}
