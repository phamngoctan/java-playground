package com.tanpham.playaround.sorting;

/*
 * For the sake of the idea implementation, this class will not support generic type
 */
public class QuickSortWithDuplicateKeysHandling {

	public void proceed(int[] arr) {
		if (arr == null) {
			return;
		}
		QuickSort.shuffleArray(arr);
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		NextBoundary nextBoundary = partition(arr, low, high);
		quickSort(arr, 0, nextBoundary.lowBoundary);
		quickSort(arr, nextBoundary.highBoundary, high);
	}

	/**
	 * There are three posibility for the changes inside one loop <br/>
	 * first: if lower, swap lt vs i, i++, lt++ <br/>
	 * second: if higher, swap i vs gt, gt--    <br/>
	 * third: if equal, i++ (always happens in the first time of the loop when i = lt) <br/>
	 */
	public NextBoundary partition(int[] arr, int low, int high) {
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
		NextBoundary nextBoundary = new NextBoundary();
		nextBoundary.lowBoundary = lt - 1;
		nextBoundary.highBoundary = i;
		return nextBoundary;
	}
	
	class NextBoundary {
		int lowBoundary;
		int highBoundary;
		public int getLowBoundary() {
			return lowBoundary;
		}
		public int getHighBoundary() {
			return highBoundary;
		}
	}
	
}
