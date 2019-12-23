package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	private QuickSort quickSort;
	
	@Before
	public void init() {
		quickSort = new QuickSort();
	}
	
	@Test
	public void partition__inCaseBiggestValueAtFirst_theReturnShouldBeOnLastPosition() {
		int[] arr = new int[] {15, 4, 8, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		assertThat(nextPartitionPoint, Matchers.equalTo(3));
		assertThat(arr, Matchers.equalTo(new int[] {2, 4, 8, 15}));
	}
	
	@Test
	public void partition__inCaseSmallestValueAtFirst_theReturnedValueShouldBeOnFirstPosition() {
		int[] arr = new int[] {2, 15, 4, 8};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		assertThat(nextPartitionPoint, Matchers.equalTo(0));
		
		makeSureNoChangeInTheOriginalArray(new int[] {2, 15, 4, 8}, arr);
	}
	
	private void makeSureNoChangeInTheOriginalArray(int[] originalArr, int[] arr) {
		assertThat(originalArr, Matchers.equalTo(arr));
	}

	@Test
	public void partition__exchangeInternalPoint() {
		int[] arr = new int[] {5, 6, 3, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(2));
		assertThat(arr, Matchers.equalTo(new int[] {3, 2, 5, 6}));
	}
	
	@Test
	public void partition__inCaseTheInputAlreadySorted() {
		int[] arr = new int[] {2, 5, 8, 11};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(0));
		assertThat(arr, Matchers.equalTo(new int[] {2, 5, 8, 11}));
	}
	
	@Test
	public void partition__inCaseTheInputIsReverted() {
		int[] arr = new int[] {11, 8, 5, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(3));
		assertThat(arr, Matchers.equalTo(new int[] {2, 8, 5, 11}));
	}
	
}
