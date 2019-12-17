package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class MergeSortArrayTest {
	private static final boolean INCREASING_ORDER = true;
	private static final boolean DECREASING_ORDER = !INCREASING_ORDER;
	private MergeSort<Integer> mergeSort;
	
	@Before
	public void init() {
		mergeSort = new MergeSort<>();
	}
	
	//Utility method test
	@Test
	public void mergeSortedArrays() {
		Comparable[] arr = new Integer[] {1, 5, 9, 3, 20, 53};
		Comparable[] auxiliary = new Integer[6];
		int low = 0;
		int mid = 2;
		int high = 5;
		mergeSort.mergeSortedArrays(arr, auxiliary, low, mid, high);
		assertThat(arr[0], Matchers.equalTo(1));
		assertThat(arr[1], Matchers.equalTo(3));
		assertThat(arr[2], Matchers.equalTo(5));
		assertThat(arr[3], Matchers.equalTo(9));
		assertThat(arr[4], Matchers.equalTo(20));
		assertThat(arr[5], Matchers.equalTo(53));
	}
	
	@Test
	public void sort_happyPath() {
		Comparable[] arr = new Integer[] {5, 2, 8, 7, 4, 3};
		Comparable[] auxiliary = new Integer[6];
		int low = 0;
		int mid = 2;
		int high = 5;
		mergeSort.sort(arr, auxiliary, low, high);
		assertThat(arr[0], Matchers.equalTo(2));
		assertThat(arr[1], Matchers.equalTo(3));
		assertThat(arr[2], Matchers.equalTo(4));
		assertThat(arr[3], Matchers.equalTo(5));
		assertThat(arr[4], Matchers.equalTo(7));
		assertThat(arr[5], Matchers.equalTo(8));
	}
	
	@Test
	public void mergeSort_oneItem() {
		Comparable[] arr = new Integer[] {5};
		mergeSort.proceedAnArray(arr);
		assertThat(arr[0], Matchers.equalTo(5));
	}
	
	@Test
	public void mergeSort_twoItem() {
		Comparable[] arr = new Integer[] {5, 2};
		mergeSort.proceedAnArray(arr);
		assertThat(arr[0], Matchers.equalTo(2));
		assertThat(arr[1], Matchers.equalTo(5));
	}
}
