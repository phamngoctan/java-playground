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
	public int partition(int[] arr, int low, int high) {
		int i = low;
		int lt = low;
		int gt = high;
		int checkPointValue = arr[low];
		
		while (i <= gt) {
			if (arr[i] > checkPointValue) {
				// Swap with gt item
				QuickSort.exchange(arr, i, gt--);
			} else if (arr[i] < checkPointValue) {
				// swap with lt item
				QuickSort.exchange(arr, lt++, i++);
			} else {
				i++;
			}
		}
		return lt;
	}
	
}
